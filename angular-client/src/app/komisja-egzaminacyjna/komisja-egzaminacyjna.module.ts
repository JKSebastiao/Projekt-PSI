import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KomisjaEgzaminacyjnaComponent } from './komisja-egzaminacyjna.component';
import { PowolanieComponent } from './powolanie/powolanie.component';
import { KomisjaEgzaminacyjnaRoutingModule } from './komisja-egzaminacyjna-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ToastModule } from 'primeng/components/toast/toast';
import { MessageService } from 'primeng/components/common/messageservice';

@NgModule({
  declarations: [KomisjaEgzaminacyjnaComponent, PowolanieComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    KomisjaEgzaminacyjnaRoutingModule,
    ToastModule
  ],
  providers: [MessageService]
})
export class KomisjaEgzaminacyjnaModule { }
