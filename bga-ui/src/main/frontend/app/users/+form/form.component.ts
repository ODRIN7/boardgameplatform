import { Component, OnInit, AfterViewInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';

import { TdMediaService } from '@covalent/core';


@Component({
  selector: 'qs-user-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class UsersFormComponent {

  displayName: string;
  email: string;
  id: string;
  admin: boolean;
  action: string;

  constructor() {}

  goBack(): void {
    window.history.back();
  }

}
