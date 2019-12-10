import {Injectable} from '@angular/core';
import {
  CanActivate,
  CanActivateChild,
  CanLoad,
  Route,
  UrlSegment,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router
} from '@angular/router';
import {Observable} from 'rxjs';
import {AuthService} from "../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate, CanActivateChild, CanLoad {

  constructor(private authService: AuthService,
              private myRoute: Router) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    console.log('Guard Login')
    if (this.authService.isLoggedIn() && this.authService.getDataUsername().tipoPersona === "PROFESOR") {
      this.myRoute.navigate(['/teacher-global/classroom'])
      return true;
    } else if (this.authService.isLoggedIn() && this.authService.getDataUsername().tipoPersona === "ALUMNO") {
      this.myRoute.navigate(['/student/homework'])
      return true;
    } else {
      return true
    }
  }

  canActivateChild(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return true;
  }

  canLoad(
    route: Route,
    segments: UrlSegment[]): Observable<boolean> | Promise<boolean> | boolean {
    return true;
  }
}

// if (this.authService.isLoggedIn() && this.authService.getDataUsername().tipoPersona === "PROFESOR") {
//   this.myRoute.navigate(['/teacher-global/classroom'])
//   return false;
// } else if (this.authService.isLoggedIn() && this.authService.getDataUsername().tipoPersona === "ALUMNO") {
//   this.myRoute.navigate(['/student/homework'])
//   return false;
// } else {
//   this.myRoute.navigate(["/"]);
//   return true;
// }
