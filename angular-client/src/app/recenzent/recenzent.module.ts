import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RecenzentListComponent } from './recenzent-list/recenzent-list.component';
import { RecenzentFormComponent } from './recenzent-form/recenzent-form.component';
import { RecenzentRoutingModule } from './recenzent-routing.module';
import { RecenzentPropozycjaComponent } from './recenzent-propozycja/recenzent-propozycja.component';
import { ToastModule } from 'primeng/components/toast/toast';
import { MessageService } from 'primeng/components/common/messageservice';

@NgModule({
  declarations: [RecenzentListComponent, RecenzentFormComponent, RecenzentPropozycjaComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RecenzentRoutingModule,
    ToastModule
  ],
  providers: [MessageService]
})
export class RecenzentModule { }
