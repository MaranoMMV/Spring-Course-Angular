import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Cliente } from '../cliente';
import {ClientesService } from '../../clientes.service';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  cliente: Cliente;
  nome: string = "Fulano";
  success: boolean = false;
  errors?: String[] | null=null;

  constructor(private service: ClientesService, private router: Router, private activatedRoute: ActivatedRoute) {
    this.cliente = new Cliente();
  }

  ngOnInit(): void {
    let params = this.activatedRoute.params;
    console.log(params.value);
  }

  voltarParaListagem() {
    this.router.navigate(['/clientes-lista'])
  }

  onSubmit() {
    this.service
      .salvar(this.cliente)
      .subscribe(response => {
        this.success = true;
        this.errors = null;
        this.cliente = response;
      }, errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
        console.log(errorResponse.error.errors)
      }
      )
  }
}
