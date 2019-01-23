import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KomisjaEgzaminacyjnaComponent } from './komisja-egzaminacyjna.component';
import { PowolanieComponent } from './powolanie/powolanie.component';
import { KomisjaEgzaminacyjnaRoutingModule } from './komisja-egzaminacyjna-routing.module';

@NgModule({
  declarations: [KomisjaEgzaminacyjnaComponent, PowolanieComponent],
  imports: [
    CommonModule,
    KomisjaEgzaminacyjnaRoutingModule
  ]
})
export class KomisjaEgzaminacyjnaModule { }
