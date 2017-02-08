import {CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {AuthServices} from '../auth/auth.services';
import {Injectable} from '@angular/core';


@Injectable()
export class AdminGuard implements CanActivate {
  constructor(private authService: AuthServices, private router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.authService.hasRole('ROLE_ADMIN')) {
      return true;
    }
    this.router.navigate(['accessDenied']);
    return false;
  }
}
