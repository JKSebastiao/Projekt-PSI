import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
 {path:'praca', loadChildren: './praca-dyplomowa/praca-dyplomowa.module#PracaDyplomowaModule'},
 {path:'komisja', loadChildren:'./komisja-egzaminacyjna/komisja-egzaminacyjna.module#KomisjaEgzaminacyjnaModule'},
  {path:'recenzent', loadChildren:'./recenzent/recenzent.module#RecenzentModule'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
