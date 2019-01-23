import { Component, OnInit } from '@angular/core';

import {FormGroup, FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-praca-dyplomowa-form',
  templateUrl: './praca-dyplomowa-form.component.html',
  styleUrls: ['./praca-dyplomowa-form.component.css']
})
export class PracaDyplomowaFormComponent implements OnInit {
  form: FormGroup;
  constructor(private formBuilder: FormBuilder) { }

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

}
