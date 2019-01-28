import { Component, OnInit } from '@angular/core';

import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import { PracaDyplomowaService } from '../praca-dyplomowa.service';

@Component({
  selector: 'app-praca-dyplomowa-form',
  templateUrl: './praca-dyplomowa-form.component.html',
  styleUrls: ['./praca-dyplomowa-form.component.css']
})
export class PracaDyplomowaFormComponent implements OnInit {
  form: FormGroup;
  constructor(private formBuilder: FormBuilder, private pracaDyplomowaService: PracaDyplomowaService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      tytul: [null,Validators.required],
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
      tytul: this.form.get('tytul').value,
      student: {
        imie: this.form.get('student').get('imie').value,
        nazwisko: this.form.get('student').get('nazwisko').value,
        nrIndeksu: this.form.get('student').get('indeks').value
      }
    }
    this.pracaDyplomowaService.addPraca(praca).subscribe(
      response => {
        alert('Praca Zgłoszona!');
        console.log(response);
      },
      error => {
        alert('Bląd w momencie zgłaszania pracy!');
        console.log(error);
      }
      );
  }

}
