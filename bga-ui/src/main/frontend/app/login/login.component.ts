import {Component, OnInit} from '@angular/core';
import {AuthServices} from '../shared/auth/auth.services';
import {Router} from '@angular/router';

@Component({
  selector: 'bga-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  private username;
  private password;
  private message;

  constructor(public authService: AuthServices, public router: Router) {
  }

  logMeIn() {
    console.log('LogMeIn');
    this.authService
      .authenticate(this.username, this.password)
      .catch(errorMessage => this.message = errorMessage)
      .then(() => {
        if (this.authService.isAuthenticated()) {
          this.router.navigate(['']);
        }
      });

  }

  ngOnInit(): any {
    console.log('hello `Login` component');
  }
}
