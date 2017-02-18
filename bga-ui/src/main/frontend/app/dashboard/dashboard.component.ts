import { Component, AfterViewInit } from '@angular/core';

@Component({
  selector: 'bga-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements AfterViewInit {

  items: Object[];
  users: Object[];
  products: Object[];

  constructor() {
  }

  ngAfterViewInit(): void {
  }
}
