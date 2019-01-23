import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KomisjaEgzaminacyjnaComponent } from './komisja-egzaminacyjna.component';
import { PowolanieComponent } from './powolanie/powolanie.component';


const routes: Routes = [
    {path: '',component: KomisjaEgzaminacyjnaComponent},
    {path: 'powolanie', component:PowolanieComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class KomisjaEgzaminacyjnaRoutingModule { }