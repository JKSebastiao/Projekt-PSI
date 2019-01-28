import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RecenzentListComponent } from './recenzent-list/recenzent-list.component';
import { RecenzentFormComponent } from './recenzent-form/recenzent-form.component';
import { RecenzentRoutingModule } from './recenzent-routing.module';
import { RecenzentPropozycjaComponent } from './recenzent-propozycja/recenzent-propozycja.component';

@NgModule({
  declarations: [RecenzentListComponent, RecenzentFormComponent, RecenzentPropozycjaComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RecenzentRoutingModule
  ]
})
export class RecenzentModule { }
