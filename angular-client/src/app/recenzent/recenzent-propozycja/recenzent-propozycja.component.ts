import { Component, OnInit } from '@angular/core';
import { RecenzentService } from '../recenzent.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MessageService } from 'primeng/components/common/messageservice';

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
    private formBuilder: FormBuilder,
    private messageService: MessageService) { }

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
    const pracaDyplomowa: PracaDyplomowa = {id: this.praca.id, tytulPoPolsku: this.praca.tytulPoPolsku,
      tytulPoAngielsku: this.praca.tytulPoAngielsku, student: this.praca.student, 
      kierunek: this.praca.kierunek, stopien: this.praca.stopien,
      recenzenci: [this.form.get('recenzent').value]};
    console.log(pracaDyplomowa);
    this.recenzentService.addPropozycja(pracaDyplomowa).subscribe(
      response => this.showSuccessMessage("Recenzent zaproponowany!"), 
      error => this.showErrorMessage("Ops! "+ error.message)
      );
  }

  showErrorMessage(message: string) {
    this.messageService.add({severity:'error', summary:'Błąd !', detail: message});
  }
  showSuccessMessage(message: string) {
    this.messageService.add({severity:'success', summary:'Sukces', detail: message});
  }

}
