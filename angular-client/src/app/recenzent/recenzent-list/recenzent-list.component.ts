import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { RecenzentService } from '../recenzent.service';

@Component({
  selector: 'app-recenzent-list',
  templateUrl: './recenzent-list.component.html',
  styleUrls: ['./recenzent-list.component.css']
})
export class RecenzentListComponent implements OnInit {
  form: FormGroup;
  listaRecenzenci: Pracownik[] = [];
  constructor(private recenzentService: RecenzentService, 
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.recenzentService.getAllRecenzenci().subscribe(response =>{
      this.listaRecenzenci = response;
      console.log(response);
    });
  }

}
