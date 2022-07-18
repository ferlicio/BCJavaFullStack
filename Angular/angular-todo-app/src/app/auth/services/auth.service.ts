import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/compat/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private authentication: AngularFireAuth // serve para manipular a parte de autenticação do firebase
  ) { }

  signUpWithEmailAndPassword(email: string, password: string) {
    return this.authentication.createUserWithEmailAndPassword(email, password);
  }
}
