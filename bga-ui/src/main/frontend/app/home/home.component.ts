import {Component} from "@angular/core";
import {AuthService} from "../shared/auth/auth.service";

@Component({
  selector: 'bga-home',
  templateUrl: 'home.component.html',
})
export class HomeComponent {

  constructor(authService: AuthService) {
    authService.tryCreateUser("aaa", "bbb");
  }

}
