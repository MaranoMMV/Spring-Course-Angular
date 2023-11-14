import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from './usuario'
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username?: string;
  password?: string;
  loginErro?: boolean;
  cadastrando?: boolean;
  mensagemSucesso?: string | null = null;


  constructor(private router: Router,
    private authService: AuthService)
  { }

  onSubmit() {
    this.router.navigate(['/home'])
  }

  preparaCadastro(event : any) {
    event.preventDefault();
    this.cadastrando = true;
  }

  cancelaCadastro() {
    this.cadastrando = false;
  }

  cadastrar() {
    const usuario: Usuario = new Usuario();
    usuario.username = this.username;
    usuario.password = this.password;
    this.authService
      .salvar(usuario)
      .subscribe( response => {

        this.mensagemSucesso = "Cadastro concluido! Efetue o login";
      },
      error => {
        this.loginErro = true;
        this.mensagemSucesso = null;
        })
  }

}