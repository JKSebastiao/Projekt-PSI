import { Component, OnInit } from '@angular/core';
import { KomisjaEgzaminacyjnaService } from '../komisja-egzaminacyjna.service';
import { FormBuilder,FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-powolanie',
  templateUrl: './powolanie.component.html',
  styleUrls: ['./powolanie.component.css']
})
export class PowolanieComponent implements OnInit {

  form: FormGroup
  pracownici: Pracownik[];
  pracowniciForPrzewodniczacy: Pracownik[];
  pracowniciForCzlonek: Pracownik[];
  noSelected = null;
  constructor(private komisjaEgzaminacyjnaService: KomisjaEgzaminacyjnaService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
    budynek: [null,Validators.required],
    sala: [null, Validators.required],
    data: [null,Validators.required],
    przewodniczacy:[null, Validators.required],
    czlonek: [null, Validators.nullValidator],
    sekretarz:[null]
    });
    this.komisjaEgzaminacyjnaService.getAllPracownik().subscribe(e => {
      this.pracownici = e.sort((a,b)=>this.pracownikComparator(a,b));
      this.pracowniciForPrzewodniczacy = this.pracownici;
      this.pracowniciForCzlonek = this.pracownici;
    },error=> console.log("Error for taking pracowniki"))
    
  }

  private onPrzewodniczacyChanged(){
    this.pracowniciForCzlonek =  this.pracownici.filter(e => e != this.form.get('przewodniczacy').value);
  }
  private onCzlonekChanged(){
    this.pracowniciForPrzewodniczacy = this.pracownici.filter(e => e != this.form.get('czlonek').value);
    this.pracowniciForPrzewodniczacy = this.pracowniciForPrzewodniczacy.filter(e => e != this.form.get('sekretarz').value);
  }
  private onSekretarzChanged(){
    this.onCzlonekChanged();
  }

  private isControlValid(control){
    return !this.form.get(control).valid && this.form.get(control).touched;
  }

  private aplyCSSErrorToSelect(control){
    return {
      'was-validated': !this.form.get(control).invalid && this.form.get(control).touched
    }
  }

  private aplyCSSError(control){
    return {
      'was-validated': this.isControlValid(control)
    }
  }

  private pracownikComparator(a:Pracownik,b:Pracownik):number{
    return a.imie > b.imie? 1 : a.imie < b.imie? -1:a.nazwisko > b.nazwisko? 1: a.nazwisko < b.nazwisko? -1:0;
  }

  private createKomisja(){
    let komisja : KomisjaEgzaminacyjna = {
      budynek: this.form.get('budynek').value,
      sala: this.form.get('sala').value,
      data: this.form.get('data').value,
      przewodniczacy: this.form.get('przewodniczacy').value,
      czlonek: this.form.get('czlonek').value,
      sekretarz: this.form.get('sekretarz').value

   };
   this.komisjaEgzaminacyjnaService.createKomisja(komisja).subscribe(response =>{
     console.log(response);
   }, error => console.log(error) );
    console.log(this.form.get('czlonek').value);
  }

  changed(){
    console.log(this.form.get('przewodniczacy').value);
  }
}
