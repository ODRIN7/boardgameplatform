import {Component, OnInit} from "@angular/core";
import {FormGroup} from "@angular/forms";
import {AuthServices} from "../shared/auth/auth.services";
import {Router} from "@angular/router";


@Component({
  selector: 'bga-signup',
  templateUrl: './sign.up.component.html',
  styleUrls: ['./sign.up.component.scss']
})
export class SignupComponent implements OnInit {

  constructor(public authService: AuthServices, public router: Router) {
  }

  onSignup() {
    this.authService.registration("userrr", "passworddd");
  }

  private username;
  private password;
  private message;


  onSignUp() {
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
