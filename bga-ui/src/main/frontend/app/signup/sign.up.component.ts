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
  private username;
  private password;
  private message;

  constructor(public authService: AuthServices, public router: Router) {
  }

  onSignUp() {
    console.log('registrate');
    this.authService.registration(this.username, this.password)
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
