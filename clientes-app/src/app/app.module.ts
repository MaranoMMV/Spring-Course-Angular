import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import{ TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component'
import { ClientesModule } from './clientes/clientes.module';
import { ClientesService } from './clientes.service';
import { ServicoPrestadoFormComponent } from './servico-prestrado/servico-prestado-form/servico-prestado-form.component';
import { ServicoPrestadoListaComponent } from './servico-prestrado/servico-prestado-lista/servico-prestado-lista.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ServicoPrestadoFormComponent,
    ServicoPrestadoListaComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    TemplateModule,
    ClientesModule
  ],
  providers: [
    ClientesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
