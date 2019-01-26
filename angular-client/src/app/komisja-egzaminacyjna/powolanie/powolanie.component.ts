import { Component, OnInit } from '@angular/core';
import { PowolanieService } from './powolanie.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-powolanie',
  templateUrl: './powolanie.component.html',
  styleUrls: ['./powolanie.component.css']
})
export class PowolanieComponent implements OnInit {

  form: FormGroup
  pracownici: Pracownik[];
  powolanaKomisji: CzlonekKomisji[]=[];

  constructor(private powolanieService: PowolanieService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
    budynek: [null,Validators.required],
    sala: [null, Validators.required],
    data: [null,Validators.required]
    });
    this.powolanieService.getAllPracownik().subscribe(e => {
      this.pracownici = e;
      this.pracownici.sort((a,b)=>this.pracownikComparator(a,b));
    },error=> console.log("Error for taking pracowniki"))
    
  }

  private dodajPrzewodniczacy(pracownik: Pracownik){
    if(this.powolanaKomisji.length<3){
      this.powolanaKomisji.push({pracownik:pracownik,role:"Przewodniczacy"});
      this.pracownici = this.pracownici.filter(e => e != pracownik);
    }
    console.log("Przewodniczący "+pracownik.nazwisko+" dodany!")
  }
  private dodajCzlonek(pracownik: Pracownik){
    if(this.powolanaKomisji.length<3){
      this.powolanaKomisji.push({pracownik:pracownik,role:"Członek"});
      this.pracownici = this.pracownici.filter(e => e != pracownik);
    }
    console.log("Członek "+pracownik.nazwisko+" dodany!")
  }
  private dodajSekretarz(pracownik: Pracownik){
    if(this.powolanaKomisji.length<3){
      this.powolanaKomisji.push({pracownik:pracownik,role:"Sekretarz"});
      this.pracownici = this.pracownici.filter(e => e != pracownik);
    }
    console.log("Sekretarz "+pracownik.nazwisko+" dodany!")
  }

  private isControlValid(control){
    return !this.form.get(control).valid && this.form.get(control).touched;

  }

  private aplyCSSError(control){
    return {
      'was-validated': this.isControlValid(control)
    }
  }

  private hasPrzewodniczacy():Boolean{
    return this.powolanaKomisji.filter(e => e.role =="Przewodniczacy").length != 0;
  }
  private hasCzlonek():Boolean{
    return this.powolanaKomisji.filter(e => e.role =="Członek").length != 0;
  }
  private hasSekretarz():Boolean{
    return this.powolanaKomisji.filter(e => e.role =="Sekretarz").length != 0;
  }

  private usunCzlonek(czlonek: CzlonekKomisji){
    const pracownik = czlonek.pracownik;
    this.powolanaKomisji = this.powolanaKomisji.filter(e => e != czlonek);
    this.pracownici.unshift(pracownik);
    //this.pracownici.sort((a,b)=> this.pracownikComparator(a,b));
  }

  private pracownikComparator(a:Pracownik,b:Pracownik):number{
    return a.imie > b.imie? 1 : a.imie < b.imie? -1:a.nazwisko > b.nazwisko? 1: a.nazwisko < b.nazwisko? -1:0;
  }

}
