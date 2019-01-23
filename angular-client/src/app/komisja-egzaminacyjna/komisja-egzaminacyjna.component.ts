import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-komisja-egzaminacyjna',
  templateUrl: './komisja-egzaminacyjna.component.html',
  styleUrls: ['./komisja-egzaminacyjna.component.css']
})
export class KomisjaEgzaminacyjnaComponent implements OnInit {

  komisjiEgzaminacyjine: KomisjaEgzaminacyjna[] = [
    {
      komisja:
      [
        {pracownik:{imie:"IP1",nazwisko:"NP1",stopienNaukowy:"dr", stanowiskoPracownika:"naukowo"},
        role:"Przewodniczący"},
        {pracownik:{imie:"IP2",nazwisko:"NP2",stopienNaukowy:"dr", stanowiskoPracownika:"naukowo"},
        role:"Członek"},
        {pracownik:{imie:"IP3",nazwisko:"NP3",stopienNaukowy:"dr", stanowiskoPracownika:"naukowo"},
        role:"Sekretarz"}
      ],
      budynek:"A1",
      sala:"231",
      data: "12.03.2019"
    },
    {
      komisja:
      [
        {pracownik:{imie:"IP2",nazwisko:"NP3",stopienNaukowy:"dr.inz", stanowiskoPracownika:"dydatyczny-naukowo"},
        role:"Przewodniczący"},
        {pracownik:{imie:"IP1",nazwisko:"NP1",stopienNaukowy:"dr", stanowiskoPracownika:"naukowo"},
        role:"Członek e Sekretarz"}
      ],
      budynek:"D2",
      sala:"123",
      data: "23.01.2018"
    }
  ]

  constructor() { }

  ngOnInit() {
  }

}
