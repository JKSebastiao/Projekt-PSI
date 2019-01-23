import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { PracaDyplomowaListComponent } from './praca-dyplomowa-list/praca-dyplomowa-list.component';
import { PracaDyplomowaFormComponent } from './praca-dyplomowa-form/praca-dyplomowa-form.component';
import { PracaDyplomowaRoutingModule } from './praca-dyplomowa-routing.module';
import { ControlErrorComponent } from './control-error/control-error.component';


@NgModule({
  declarations: [PracaDyplomowaListComponent, PracaDyplomowaFormComponent, ControlErrorComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    PracaDyplomowaRoutingModule
  ]
})
export class PracaDyplomowaModule { }
