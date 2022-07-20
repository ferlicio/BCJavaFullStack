import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { Router } from '@angular/router';
import { from, tap } from 'rxjs';
import { Todo } from 'src/app/models/Todo';
import { User } from 'src/app/models/User';
import { GoogleAuthProvider } from 'firebase/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  //criar uma propriedade com a referencia da coleção de usuários do firebase
  private usersCollection = this.store.collection<User>('users')

  constructor(
    private authentication: AngularFireAuth, // serve para manipular a parte de autenticação do firebase
    private store: AngularFirestore, // serve para manipular a parte de banco de dados do firebase
    private router: Router
  ) { }

  get currentUser() {
    /**
     * authState retorna um observable que contém o usuário atual se ele estiver logado
     * ou null se não estiver logado
     */
    return this.authentication.authState
  }

  private saveUserData() {
    return tap(async (credentials:firebase.default.auth.UserCredential) => {
      //recuperar o uid do usuário
      const uid = credentials.user?.uid as string

      //recuperar o email do usuário
      const email = credentials.user?.email as string

      const todos: Todo[] = []

      //SELECT * FROM users WHERE email = email;
      const user = await this.usersCollection.ref.where('email', '==', email).get() //where(param1, teste a ser feito, param2))
      .then(users => {
        return users.docs[0]
      })

      if(user == undefined){
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
      }
    })
  }

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
     this.saveUserData() 
    )
  }

  signInWithEmailAndPassword(email: string, password: string) {
    return from(this.authentication.signInWithEmailAndPassword(email, password))//retorna uma promisse - usa o from para transformar a promisse em um observable
  }
  
  signInWithGoogle() {
    //const googleProvider = new GoogleAuthProvider()
    //return from(this.authentication.signInWithPopup(googleProvider))

    return from(this.authentication.signInWithPopup(new GoogleAuthProvider()))
    .pipe(
      this.saveUserData()
    )
  }

    
  signOut() {
    return from(this.authentication.signOut())
    .pipe(
      tap(() => {
        this.router.navigateByUrl('/auth/login')
      })
    )
  }
 

}
