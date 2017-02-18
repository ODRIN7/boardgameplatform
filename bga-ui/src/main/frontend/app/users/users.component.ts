import { Component, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { MdSnackBar } from '@angular/material';

import { TdLoadingService, TdDialogService, TdMediaService } from '@covalent/core';


@Component({
  selector: 'qs-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
})
export class UsersComponent {


  constructor() {
  }

}
