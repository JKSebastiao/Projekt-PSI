import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
 {path:'praca', loadChildren: './praca-dyplomowa/praca-dyplomowa.module#PracaDyplomowaModule'},
 {path:'komisja', loadChildren:'./komisja-egzaminacyjna/komisja-egzaminacyjna.module#KomisjaEgzaminacyjnaModule'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
