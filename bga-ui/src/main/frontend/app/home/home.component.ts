import {Component} from "@angular/core";
import {AuthService} from "../shared/auth/auth.services";

@Component({
  selector: 'bga-home',
  templateUrl: 'home.component.html',
})
export class HomeComponent {

  constructor( public authService: AuthService) {

  }

}
