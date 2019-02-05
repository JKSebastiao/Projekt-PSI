import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { RecenzentService } from '../recenzent.service';

@Component({
  selector: 'app-recenzent-form',
  templateUrl: './recenzent-form.component.html',
  styleUrls: ['./recenzent-form.component.css']
})
export class RecenzentFormComponent implements OnInit {

  form: FormGroup;
  listaPracyZRecenzentamiZaproponowanych: PracaDyplomowa[] = [];
  pracaDyplomowa: PracaDyplomowa;
  pracownici: Pracownik[]=[];
  noSelected = null;
  edit : Boolean = false;
  constructor(
    private recenzentService: RecenzentService, 
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.recenzentService.getAllPracyZRecenzentemZaproponowany().subscribe(response =>{
      this.listaPracyZRecenzentamiZaproponowanych = response;
      console.log(response);
    });
    this.recenzentService.getAllPracownik().subscribe(response =>this.pracownici = response);
    this.form = this.formBuilder.group({
      recenzent: [null]
    });
    
  }

  private powolaj(praca: PracaDyplomowa){
    this.pracaDyplomowa = praca;
  }

  private addPropozycja(){
    
  }

  private editMethod(){
    this.edit = true;
    console.log(this.edit);
  }

  private akceptuj(){
  
  }

}
