import { Component, OnInit } from '@angular/core';
import { KomisjaEgzaminacyjnaService } from '../komisja-egzaminacyjna.service';
import { FormBuilder,FormGroup, Validators } from '@angular/forms';
import { MessageService } from 'primeng/components/common/messageservice';

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
  roli: string[] = ["Przewodniczący","Członek","Sekretasz"];
  czlonki: Czlonek[] = [];
  noSelected = null;
  constructor(
    private komisjaEgzaminacyjnaService: KomisjaEgzaminacyjnaService, 
    private formBuilder: FormBuilder,
    private messageService: MessageService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
    budynek: [null,Validators.required],
    sala: [null, Validators.required],
    data: [null,Validators.required],
    godzina:[null,Validators.required],
    czlonek: [null, Validators.nullValidator],
    rola:[null, Validators.required]
    });
    this.komisjaEgzaminacyjnaService.getAllPracownik().subscribe(e => {
      this.pracownici = e.sort((a,b)=>this.pracownikComparator(a,b));
      this.pracowniciForPrzewodniczacy = this.pracownici;
      this.pracowniciForCzlonek = this.pracownici;
    },error=> this.showErrorMessage("Ops! jakiś błąd na serwerze"))
    
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

  private addCzlonek(){
    let toAdd:Boolean = true;
    let czlonek: Czlonek ={
      pracownik: this.form.get('czlonek').value,
      rola: this.form.get('rola').value
    };
    if(czlonek.rola !== "Członek"){
      this.czlonki.forEach(e =>{
        if(e.rola === czlonek.rola){
          this.showErrorMessage("Juz dodałeś "+ czlonek.rola+ " w Komisji");
           toAdd = false;
        }
      })
    }
    
    if(toAdd){
      this.czlonki.push(czlonek);
      this.showSuccessMessage(czlonek.rola+' dodany!');
    }
    
    console.log(czlonek);
  }

  private pracownikComparator(a:Pracownik,b:Pracownik):number{
    return a.imie > b.imie? 1 : a.imie < b.imie? -1:a.nazwisko > b.nazwisko? 1: a.nazwisko < b.nazwisko? -1:0;
  }

  private createKomisja(){
   let czlonkiKomisji: KomisjaPracownik[] = []; 
   this.czlonki.forEach( e => czlonkiKomisji.push({pracownik: e.pracownik, rola: e.rola}));
   
   let komisja : KomisjaEgzaminacyjna = {
    budynek: this.form.get('budynek').value,
    sala: this.form.get('sala').value,
    date: this.form.get('data').value,
    time: this.form.get('godzina').value,
    czlonki: czlonkiKomisji
 };
  this.komisjaEgzaminacyjnaService.createKomisja(komisja).subscribe(response =>{
     this.showSuccessMessage("E-mail został wysławy do członki komisji!")
   }, error => {
     if(error.status === 201){
      this.showSuccessMessage("E-mail został wysławy do członki komisji!")
     }
     else
         this.showErrorMessage("Kolizja godzinami luz przewodniczacy nie wypełnia wymagania");
    });
  }

  deleteCzlonek(czlonek:Czlonek){
    this.czlonki = this.czlonki.filter(e => e !== czlonek);
  }

  changed(){
    console.log(this.form.get('przewodniczacy').value);
  }

  showErrorMessage(message: string) {
    this.messageService.add({severity:'error', summary:'Błąd !', detail: message});
  }
  showSuccessMessage(message: string) {
    this.messageService.add({severity:'success', summary:'Sukces', detail: message});
  }

  clear() {
      this.messageService.clear();
  }
}
