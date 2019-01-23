import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PracaDyplomowaListComponent } from './praca-dyplomowa-list/praca-dyplomowa-list.component';
import { PracaDyplomowaFormComponent } from './praca-dyplomowa-form/praca-dyplomowa-form.component';

const routes: Routes = [
    {path: '',component: PracaDyplomowaListComponent},
    {path: 'zgloszenie', component:PracaDyplomowaFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PracaDyplomowaRoutingModule { }