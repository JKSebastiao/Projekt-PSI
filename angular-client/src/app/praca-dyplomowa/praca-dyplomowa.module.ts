import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PracaDyplomowaListComponent } from './praca-dyplomowa-list/praca-dyplomowa-list.component';
import { PracaDyplomowaFormComponent } from './praca-dyplomowa-form/praca-dyplomowa-form.component';
import { PracaDyplomowaRoutingModule } from './praca-dyplomowa-routing.module';

@NgModule({
  declarations: [PracaDyplomowaListComponent, PracaDyplomowaFormComponent],
  imports: [
    CommonModule,
    PracaDyplomowaRoutingModule
  ]
})
export class PracaDyplomowaModule { }
