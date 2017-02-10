import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {APP_MENU, AppMenuItem} from './app.menu';
import {AuthService} from "./shared/auth/auth.services";

@Component({
  selector: 'bga-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class BGAMyAppComponent implements OnInit {

  public loading: boolean = false;

  views: AppMenuItem[] = APP_MENU;

  constructor(public authService: AuthService, public router: Router) {
  }

  logMeOut(): void {
    this.authService.logout();
    this.router.navigate(['']);
  }

  ngOnInit(): any {
    console.log('app on init');
  }

}
