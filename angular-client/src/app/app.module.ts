import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { HttpClientModule } from '@angular/common/http';

import { RecenzentListComponent } from './recenzent/recenzent-list/recenzent-list.component';
import { RecenzentFormComponent } from './recenzent/recenzent-form/recenzent-form.component';
import { KomisjaListComponent } from './komisja/komisja-list/komisja-list.component';
import { KomisjaFormComponent } from './komisja/komisja-form/komisja-form.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationBarComponent,
    KomisjaListComponent,
    KomisjaFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
