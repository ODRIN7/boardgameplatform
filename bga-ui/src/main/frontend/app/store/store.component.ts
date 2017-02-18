import { Component, AfterViewInit } from '@angular/core';

import { TdMediaService } from '@covalent/core';

@Component({
  selector: 'bga-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss'],
})
export class StoreComponent implements AfterViewInit {

  constructor(public media: TdMediaService) {

  }

  ngAfterViewInit(): void {
    // broadcast to all listener observables when loading the page
    this.media.broadcast();
  }

}
