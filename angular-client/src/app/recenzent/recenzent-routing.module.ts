import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RecenzentListComponent } from './recenzent-list/recenzent-list.component';
import { RecenzentFormComponent } from './recenzent-form/recenzent-form.component';

const routes: Routes = [
  {path: '',component: RecenzentListComponent},
  {path: 'zaproponuj', component:RecenzentFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RecenzentRoutingModule { }
