import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { map, Observable } from 'rxjs';
import { AuthService } from '../auth/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AccessTodosGuard implements CanActivate {

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.authService.currentUser
    .pipe(
      map((user) => {
        if (user == null) {
          return this.router.parseUrl('/auth/login'); // parseURL retorna uma urltree e navigatebyUrl retorna uma promise, por isso não pode ser usado aqui

        } else if(!user.emailVerified) { 
          user.sendEmailVerification()
          return this.router.parseUrl('/auth/verify-email');

        } else {
          return true;

        }
      })
    );
  }
  
}
