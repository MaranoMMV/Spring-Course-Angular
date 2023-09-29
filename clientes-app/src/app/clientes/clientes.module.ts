import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';
import { ClientesRoutingModule } from './clientes-routing.module';

@NgModule({
  declarations: [
    ClientesFormComponent,
    ClientesListaComponent
  ],
  imports: [
    CommonModule,
    ClientesRoutingModule,
    FormsModule
  ], exports: [
    ClientesFormComponent,
    ClientesListaComponent
  ]
})
export class ClientesModule { }