import { Component, OnInit } from '@angular/core';

import {FormGroup, FormBuilder} from '@angular/forms';

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
      tytul: [null],
      student: this.formBuilder.group({
        imie: [null],
        nazwisko:[null],
        indeks:[null]
      })
    });
  }

}
