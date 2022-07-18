import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { from, tap } from 'rxjs';
import { Todo } from 'src/app/models/Todo';
import { User } from 'src/app/models/User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  //criar uma propriedade com a referencia da coleção de usuários do firebase
  private usersCollection = this.store.collection<User>('users')

  constructor(
    private authentication: AngularFireAuth, // serve para manipular a parte de autenticação do firebase
    private store: AngularFirestore // serve para manipular a parte de banco de dados do firebase
  ) { }

  signUpWithEmailAndPassword(email: string, password: string) {
    /**
     * O from transformará a promisse que o metodo signUpWithEmailAndPassword retorna 
     * em um observable
     * 
     * O metodo CreateUserWithEmailAndPassword cadastra um novo usuário no firebase
     * pelo email e senha
     */
    return from(this.authentication.createUserWithEmailAndPassword(email, password))
    .pipe(
      tap((credentials) => {
        //recuperar o uid do usuário
        const uid = credentials.user?.uid as string

        //recuperar o email do usuário
        const email = credentials.user?.email as string

        const todos: Todo[] = []

        //criação de um novo documento na coleção de usuarios
        /**
         * a função doc te retorna a referencia para um documento na coleção
         * a partir de seu UID
         * 
         * a função set atribui valores ao documento que você esta se referenciando
         */
        this.usersCollection.doc(uid).set({
          uid: uid,
          email: email,
          todos: todos
        })

        //envia o email de verificação
        credentials.user?.sendEmailVerification()
      })
    )
  }
}
