import { Component, OnInit, AfterViewInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';

import { TdMediaService } from '@covalent/core';

@Component({
  selector: 'bga-signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.scss'],
})
export class SignUpComponent implements OnInit{

  username: string;
  email: string;
  id: string;
  admin: boolean;
  action: string;
  password1: string;
  password2: string;

  constructor(private _route: ActivatedRoute,
              public media: TdMediaService) {}

  goBack(): void {
    window.history.back();
  }

  signUp(): void {

  }

  ngOnInit(): any {
    console.log('app on init');
  }
}
