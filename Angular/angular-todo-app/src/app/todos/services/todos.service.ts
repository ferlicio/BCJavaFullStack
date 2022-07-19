import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { map, mergeMap } from 'rxjs';
import { AuthService } from 'src/app/auth/services/auth.service';
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
        return userDoc.data()?.todos || [] //recupera o array de todos do usuário
      })
    )
  }
}
