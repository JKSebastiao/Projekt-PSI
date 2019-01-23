import { Component, OnInit } from '@angular/core';
import { PowolanieService } from './powolanie.service';

@Component({
  selector: 'app-powolanie',
  templateUrl: './powolanie.component.html',
  styleUrls: ['./powolanie.component.css']
})
export class PowolanieComponent implements OnInit {

  pracownici: Pracownik[];

  constructor(private powolanieService: PowolanieService) { }

  ngOnInit() {
    this.powolanieService.getAllPracownik().subscribe(e => this.pracownici = e,error=> console.log("Error for taking pracowniki"))
  }

  private dodajPrzewodniczacy(pracownik: Pracownik){
    console.log("Przewodniczący "+pracownik.nazwisko+" dodany!")
  }
  private dodajCzlonek(pracownik: Pracownik){
    console.log("Członek "+pracownik.nazwisko+" dodany!")
  }
  private dodajSekretarz(pracownik: Pracownik){
    console.log("Sekretarz "+pracownik.nazwisko+" dodany!")
  }

}
