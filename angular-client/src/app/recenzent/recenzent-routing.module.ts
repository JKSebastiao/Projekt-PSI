import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RecenzentListComponent } from './recenzent-list/recenzent-list.component';
import { RecenzentFormComponent } from './recenzent-form/recenzent-form.component';
import { RecenzentPropozycjaComponent } from './recenzent-propozycja/recenzent-propozycja.component';

const routes: Routes = [
  {path: '',component: RecenzentListComponent},
  {path: 'powolanie', component:RecenzentFormComponent},
  {path: 'proponowanie', component:RecenzentPropozycjaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RecenzentRoutingModule { }
