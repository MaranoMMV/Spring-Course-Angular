
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './clientes/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor( private http: HttpClient) {  }

  salvar(cliente: Cliente) : Observable<Cliente>{
    return this.http.post<Cliente>('http://localhost:8080/api/clientes',cliente)
  }

  atualizar(cliente: Cliente) : Observable<any>{
    return this.http.put<Cliente>(`http://localhost:8080/api/clientes/${cliente.id}`,cliente)
  }

  getClientes() : Observable<Cliente[]>{
    return this.http.get<Cliente[]>('http://localhost:8080/api/clientes');
  }

  // getClientes() : Cliente[]{
  //   let cliente = new Cliente();
  //   cliente.id = 1;
  //   cliente.nome = 'Fulano';
  //   cliente.dataCadastro = '18/04/2020';
  //   cliente.cpf = '12345678900';
  //   return [cliente];
  // }
  getClienteById(id: number) : Observable<Cliente> {
    return this.http.get<any>(`http://localhost:8080/api/clientes/${id}`);
  }

  deletar(cliente: Cliente) : Observable<any>{
    return this.http.delete<any>(`http://localhost:8080/api/clientes/${cliente.id}`);
  }
  
}
