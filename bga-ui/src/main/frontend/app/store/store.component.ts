import {Component, AfterViewInit, OnInit} from '@angular/core';

import { TdMediaService } from '@covalent/core';
import {Boardgame} from "../shared/domain/boardgame";
import {StoreService} from "../shared/services/store.service";

@Component({
  selector: 'bga-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss'],
})
export class StoreComponent implements AfterViewInit, OnInit {


  public boardGames: Boardgame[];

  constructor(public media: TdMediaService,
  public storeService:StoreService) {

  }

  ngOnInit(): void {
    this.boardGames = this.storeService.boardGames;
    this.storeService.boardGamesChanged.subscribe(
      (boardGames: Boardgame[]) => this.boardGames = boardGames
    );
  }

  ngAfterViewInit(): void {
    // broadcast to all listener observables when loading the page
    this.media.broadcast();
    this.storeService.fetchData();
  }

}
