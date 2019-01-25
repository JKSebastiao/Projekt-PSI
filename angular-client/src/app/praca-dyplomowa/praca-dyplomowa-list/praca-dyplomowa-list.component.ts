import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-praca-dyplomowa-list',
  templateUrl: './praca-dyplomowa-list.component.html',
  styleUrls: ['./praca-dyplomowa-list.component.css']
})
export class PracaDyplomowaListComponent implements OnInit {
  private listaPracDyplomowych: PracaDyplomowa[] = [
    {id:1,tytul:"Cos Tam 1",student:{id:1, imie:'Imie 1',nazwisko:'Nazwisko 1',indeks:'223183'}},
    {id:2,tytul:"Cos Tam 2",student:{id:1, imie:'Imie 2',nazwisko:'Nazwisko 2',indeks:'223133'}},
    {id:3,tytul:"Cos Tam 3",student:{id:1, imie:'Imie 3',nazwisko:'Nazwisko 3',indeks:'204185'}},
  ];

  constructor() { }

  ngOnInit() {
  }

}
