import { Component, OnInit } from '@angular/core';
import { KomisjaEgzaminacyjnaService } from './komisja-egzaminacyjna.service';

@Component({
  selector: 'app-komisja-egzaminacyjna',
  templateUrl: './komisja-egzaminacyjna.component.html',
  styleUrls: ['./komisja-egzaminacyjna.component.css']
})
export class KomisjaEgzaminacyjnaComponent implements OnInit {

  listaKomisjaEgzaminacyjnych: KomisjaEgzaminacyjna[]=[];
  constructor(private komisjaEgzaminacyjnaService: KomisjaEgzaminacyjnaService) { }

  ngOnInit() {
    this.komisjaEgzaminacyjnaService.getAllKomisja().subscribe(e => this.listaKomisjaEgzaminacyjnych = e, error => alert(error.massage) );
  }

  equals(o1: Pracownik, o2: Pracownik): Boolean{
    return o1.id == o2.id;
  }

}
