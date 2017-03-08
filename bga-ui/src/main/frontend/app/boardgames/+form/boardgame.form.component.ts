import {Component, OnInit, AfterViewInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {TdMediaService} from "@covalent/core";
import {User} from "../../shared/domain/user";
import {AuthService} from "../../shared/services/auth/auth.services";


@Component({
  selector: 'bga-boardgames-admin-form',
  templateUrl: './boardgame.form.component.html',
  styleUrls: ['./boardgame.form.component.scss'],
})
export class BoardGameFormComponent implements AfterViewInit {

  displayName: string;
  email: string;
  id: string;
  admin: boolean;
  user: User;
  action: string;

  constructor(private _usersService: AuthService,
              private _route: ActivatedRoute,
              public media: TdMediaService) {
  }

  goBack(): void {
    window.history.back();
  }

  ngAfterViewInit(): void {
    // broadcast to all listener observables when loading the page
    this.media.broadcast();
  }

  ngOnInit(): void {
    /*this._route.url.subscribe((url: any) => {
      this.action = (url.length > 1 ? url[1].path : 'add');
    });
    this._route.params.subscribe((params: {id: string}) => {
      let userId: string = params.id;
      this._usersService.getUser(userId).subscribe((user: any) => {
        this.displayName = user.displayName;
        this.email = user.email;
        this.admin = (user.siteAdmin === 1 ? true : false);
        this.id = user.id;
      });
    });*/
  }

  save(): void {

  }
}
