import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'bga-not-found',
  templateUrl: 'not-found.component.html',
})
export class NotFoundComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
    console.log('route not found');
  }

}
