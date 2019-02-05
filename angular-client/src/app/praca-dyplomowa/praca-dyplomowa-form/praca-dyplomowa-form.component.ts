import { Component, OnInit } from '@angular/core';

import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import { PracaDyplomowaService } from '../praca-dyplomowa.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MessageService } from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-praca-dyplomowa-form',
  templateUrl: './praca-dyplomowa-form.component.html',
  styleUrls: ['./praca-dyplomowa-form.component.css']
})
export class PracaDyplomowaFormComponent implements OnInit {
  form: FormGroup;
  kieruneki: string[]=["Informatyka", "Robotyka", "Telekomunikacja"].sort();
  stopieni: string[]=["I","II","III"];
  idPracy: number;
  constructor(
    private formBuilder: FormBuilder, 
    private pracaDyplomowaService: PracaDyplomowaService,
    private router: Router, 
    private route: ActivatedRoute,
    private messageService: MessageService) { }

  ngOnInit() {
    this.idPracy = this.route.snapshot.params['id'];
    this.getDataToUpdate(this.idPracy);
    this.form = this.formBuilder.group({
      tytulPoPolsku: [null,Validators.required],
      tytulPoAngielsku: [null,Validators.required],
      kierunek: [null,Validators.required],
      stopien: [null,Validators.required],
      student: this.formBuilder.group({
        imie: [null,Validators.required],
        nazwisko:[null,Validators.required],
        indeks:[null,Validators.required]
      })
    });
  }

  private isControlValid(control){
    return !this.form.get(control).valid && this.form.get(control).touched;

  }

  private aplyCSSError(control){
    return {
      'was-validated': this.isControlValid(control)
    }
  }

  addPracaDyplomowa(){
    let praca: PracaDyplomowa = {
      tytulPoPolsku: this.form.get('tytulPoPolsku').value,
      tytulPoAngielsku: this.form.get('tytulPoAngielsku').value,
      kierunek: this.form.get('kierunek').value,
      stopien: this.form.get('stopien').value,
      student: {
        imie: this.form.get('student').get('imie').value,
        nazwisko: this.form.get('student').get('nazwisko').value,
        nrIndeksu: this.form.get('student').get('indeks').value
      }
    }
    if(this.idPracy){
        this.pracaDyplomowaService.updatePraca(this.idPracy,praca).subscribe(
          response => {
            this.showSuccessMessage('Praca zmodyfikowana!')
          },
          error => {
            this.showErrorMessage('Bląd w momencie korekty pracy!')
          });
    }
    else{
      this.pracaDyplomowaService.addPraca(praca).subscribe(
        response => {
          this.showSuccessMessage('Praca Zgłoszona!')
        },
        error => {
          alert('Bląd w momencie zgłaszania pracy!');
        });
    }
  }

  private getDataToUpdate(id: number){
   if(id){
     this.pracaDyplomowaService.getPracaById(id).subscribe(
       response => {
        this.form.get('tytulPoPolsku').setValue(response.tytulPoPolsku);
        this.form.get('tytulPoAngielsku').setValue(response.tytulPoAngielsku);
        this.form.get('kierunek').setValue(response.kierunek);
        this.form.get('stopien').setValue(response.stopien);
        this.form.get('student').get('imie').setValue(response.student.imie);
        this.form.get('student').get('nazwisko').setValue(response.student.nazwisko);
        this.form.get('student').get('indeks').setValue(response.student.nrIndeksu);
       },
       error => console.log(error)
     );
   }
  }

  showErrorMessage(message: string) {
    this.messageService.add({severity:'error', summary:'Błąd !', detail: message});
  }
  showSuccessMessage(message: string) {
    this.messageService.add({severity:'success', summary:'Sukces', detail: message});
  }

}
