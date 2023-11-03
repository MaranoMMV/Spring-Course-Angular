import { Component, OnInit } from '@angular/core';

import { Cliente } from '../cliente';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit{

  cliente: Cliente;
  nome: string = "Fulano";

  constructor() {
    this.cliente = new Cliente();
    this.cliente.nome = 'Mathews';
}

    ngOnInit(): void {
    }

  onSubmit() {
    console.log(this.cliente);
  }

}
