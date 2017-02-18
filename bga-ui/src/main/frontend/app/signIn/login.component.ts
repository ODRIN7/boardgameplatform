import {Component} from "@angular/core";
import {Router} from "@angular/router";
import {TdLoadingService} from "@covalent/core";

@Component({
  selector: 'qs-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  username: string;
  password: string;

  constructor(public router: Router,
              public loadingService: TdLoadingService) {
  }

  login(): void {
    this.loadingService.register();
    alert('Mock log in as ' + this.username);
    setTimeout(() => {
      this.router.navigate(['/']);
      this.loadingService.resolve();
    }, 2000);
  }

  loginWithFacebook(): void {
    this.loadingService.register();
    alert('Mock log in as ' + this.username);
    setTimeout(() => {
      this.router.navigate(['/']);
      this.loadingService.resolve();
    }, 2000);
  }

  signUp(): void {
    this.router.navigate(['/signup']);
  }

  goBack(): void {
    window.history.back();
  }
}
