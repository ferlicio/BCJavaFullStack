import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { map, mergeMap } from 'rxjs';
import { AuthService } from 'src/app/auth/services/auth.service';
import { Todo } from 'src/app/models/Todo';
import { User } from '../../models/User';

@Injectable({
  providedIn: 'root'
})
export class TodosService {
  private usersCollection = this.store.collection<User>('users')
  private currentUser = this.authService.currentUser

  constructor(
    private store: AngularFirestore,
    private authService: AuthService
  ) { }

  getTodos() {
    return this.currentUser
    .pipe(
      mergeMap(user => { //mergeMap 
        return this.usersCollection.doc(user?.uid).get() //acessa a coleção de usuarios e retorna o documento com o id do usuario
      }),
      map(userDoc => {
        return userDoc.data()?.todos || [] //recupera o array de todos do usuário ou retorna um array vazio
      })
    )
  }

  createTodo(todo: Todo) {
    return this.currentUser
    .pipe(
      mergeMap(user => { //mergeMap 
        return this.usersCollection.doc(user?.uid).get() //acessa a coleção de usuarios e retorna o documento com o id do usuario
      }),
      mergeMap(userdoc => {
        /**
         * a função data retorna um objeto com os dados do documento
         * do firebase
         */
        const user = userdoc.data() as User // 

        todo.id = this.store.createId() //cria um id para o todo

        user.todos.push(todo) //adiciona o todo ao array de todos do usuario

        return userdoc.ref.update(user) //atualiza o documento com o array de todos do usuario
      })
    )
  }

  deleteTodo(todo: Todo) {
    return this.currentUser
    .pipe(
      mergeMap(user => { //mergeMap 
        return this.usersCollection.doc(user?.uid).get() //acessa a coleção de usuarios e retorna o documento com o id do usuario
      }),
      mergeMap(userdoc => {
        /**
         * a função data retorna um objeto com os dados do documento
         * do firebase
         */
        const user = userdoc.data() as User // 

        user.todos = user.todos.filter(t => {
          return t.id !== todo.id //filtra o array de todos do usuario removendo o todo com o id passado
        }) //remove o todo do array de todos do usuario

        return userdoc.ref.update(user) //atualiza o documento com o array de todos do usuario
      })
    )
  }

  updateTodo(todo: Todo) {
    return this.currentUser
    .pipe(
      mergeMap(user => { //mergeMap 
        return this.usersCollection.doc(user?.uid).get() //acessa a coleção de usuarios e retorna o documento com o id do usuario
      }),
      mergeMap(userdoc => {
        /**
         * a função data retorna um objeto com os dados do documento
         * do firebase
         */
        const user = userdoc.data() as User // 

        user.todos = user.todos.map(t => {
          if (t.id == todo.id) {
            return todo
          }
          return t
        }) 

        return userdoc.ref.update(user) //atualiza o documento com o array de todos do usuario
      })
    )
  }

}
