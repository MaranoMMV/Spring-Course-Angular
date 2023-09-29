import { Component, OnInit } from '@angular/core';
import { Router , ActivatedRoute} from '@angular/router';

import { ClientesService } from '../../clientes.service';
import { Cliente } from '../cliente';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  cliente: Cliente;
  success: boolean = false;
  errors: String[];
  id: number;

  constructor( private service: ClientesService, private router: Router, private activatedRoute: ActivatedRoute ) {
  }


  voltarParaListagem(){
    this.router.navigate(['/clientes-lista'])
  }

  ngOnInit(): void {
    let params = this.activatedRoute.params
    if(params && params.value && params.value.id){
      this.id = (params.value.id);
      this.service.getClienteById(this.id)
                  .subscribe( response => this.cliente = response
                  ,errorResponse => this.cliente = new Cliente());
    }
  }

  onSubmit(){
    this.service
    .salvar(this.cliente)
    .subscribe( response => {
      this.success = true;
      this.errors = [];
      this.cliente = response;
    }, errorResponse =>{
      this.success = false;
      this.errors = errorResponse.error.errors;
      }
    )
  }

}