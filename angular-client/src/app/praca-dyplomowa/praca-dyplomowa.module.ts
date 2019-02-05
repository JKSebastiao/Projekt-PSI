import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { PracaDyplomowaListComponent } from './praca-dyplomowa-list/praca-dyplomowa-list.component';
import { PracaDyplomowaFormComponent } from './praca-dyplomowa-form/praca-dyplomowa-form.component';
import { PracaDyplomowaRoutingModule } from './praca-dyplomowa-routing.module';
import { ToastModule } from 'primeng/components/toast/toast';
import { MessageService } from 'primeng/components/common/messageservice';


@NgModule({
  declarations: [PracaDyplomowaListComponent, PracaDyplomowaFormComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    PracaDyplomowaRoutingModule,
    ToastModule
  ],
  providers: [MessageService]
})
export class PracaDyplomowaModule { }
