import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KomisjaEgzaminacyjnaComponent } from './komisja-egzaminacyjna.component';
import { PowolanieComponent } from './powolanie/powolanie.component';
import { KomisjaEgzaminacyjnaRoutingModule } from './komisja-egzaminacyjna-routing.module';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [KomisjaEgzaminacyjnaComponent, PowolanieComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    KomisjaEgzaminacyjnaRoutingModule
  ]
})
export class KomisjaEgzaminacyjnaModule { }
