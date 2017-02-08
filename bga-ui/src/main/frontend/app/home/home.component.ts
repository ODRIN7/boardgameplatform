import {Component} from "@angular/core";
import {AuthServices} from "../shared/auth/auth.services";

@Component({
  selector: 'bga-home',
  templateUrl: 'home.component.html',
})
export class HomeComponent {

  constructor(authService: AuthServices) {
    authService.tryCreateUser("aaa", "bbb");
  }

}
