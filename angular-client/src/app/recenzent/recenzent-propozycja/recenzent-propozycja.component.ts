import { Component, OnInit } from '@angular/core';
import { RecenzentService } from '../recenzent.service';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-recenzent-propozycja',
  templateUrl: './recenzent-propozycja.component.html',
  styleUrls: ['./recenzent-propozycja.component.css']
})
export class RecenzentPropozycjaComponent implements OnInit {
  form: FormGroup;
  listaPracDyplomowych: PracaDyplomowa[] = [];
  praca: PracaDyplomowa;
  pracownici: Pracownik[]=[];
  noSelected = null;
  constructor(
    private recenzentService: RecenzentService, 
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.recenzentService.getAllPraca().subscribe(response =>{
      this.listaPracDyplomowych = response;
    });
    this.recenzentService.getAllPracownik().subscribe(response =>this.pracownici = response);
    this.form = this.formBuilder.group({
      recenzent: [null]
    });
    
  }

  private zaproponuj(praca: PracaDyplomowa){
    this.praca = praca;
  }

  private addPropozycja(){
    const recenzent: Recenzent = {listaPracyDyplomowych:[this.praca],pracownik:this.form.get('recenzent').value, powolany:false};
    console.log(recenzent);
    this.recenzentService.addPropozycja(recenzent).subscribe(
      response => console.log(response), 
      error => console.log(error)
      );
  }

}
