import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {AuthService} from "../shared/services/auth/auth.services";

@Component({
  selector: 'bga-signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.scss'],
})
export class SignUpComponent implements OnInit {

  username: string;
  email: string;
  id: string;
  admin: boolean;
  action: string;
  password1: string;
  password2: string;
  message: string;


  constructor(public authService: AuthService,
              public router: Router) {
  }

  onSignUp() {
    console.log('registrate');
    if(this.password1 != this.password2){
      this.message = "passwords are not equals";

      return;
    }
    this.authService.registration(this.username, this.password1)
      .catch(errorMessage => this.message = errorMessage)
      .then(() => {
        if (this.authService.isAuthenticated()) {
          this.router.navigate(['']);
        }
      });
  }

  goBack(): void {
    window.history.back();
  }

  ngOnInit(): any {
    console.log('hello `Login` component');
  }
}
