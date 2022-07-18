import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full', //http://localhost:4200/
    redirectTo: 'todos'
  },
  {
    path: 'todos',
    loadChildren: () => import('./todos/todos.module').then(m => m.TodosModule)//lazy loading
  },
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)//auth module com lazy loading
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
