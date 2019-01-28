import { Component, OnInit } from '@angular/core';
import { PracaDyplomowaService } from '../praca-dyplomowa.service';

@Component({
  selector: 'app-praca-dyplomowa-list',
  templateUrl: './praca-dyplomowa-list.component.html',
  styleUrls: ['./praca-dyplomowa-list.component.css']
})
export class PracaDyplomowaListComponent implements OnInit {
  private listaPracDyplomowych: PracaDyplomowa[] = [];

  constructor(private pracaDyplomowaService: PracaDyplomowaService) { }

  ngOnInit() {
    this.pracaDyplomowaService.getAllPraca().subscribe(
      response => {
        this.listaPracDyplomowych = response;
        console.log(response);
      },
      error => console.log(error)
    );
  }

}
