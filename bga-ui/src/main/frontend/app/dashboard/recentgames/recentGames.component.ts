import {Component, OnInit, AfterViewInit} from '@angular/core';
import {Boardgame} from "../../shared/domain/boardgame";
import {StoreService} from "../../shared/services/store.service";

@Component({
  selector: 'bga-recentGames',
  templateUrl: './recentGames.component.html',
  styleUrls: ['./recentGames.component.scss'],
})
export class RecentGamesComponent implements AfterViewInit, OnInit {

  public boardGames: Boardgame[];

  constructor(public storeService: StoreService) {

  }

  ngOnInit(): void {
    this.boardGames = this.storeService.boardGames;
    this.storeService.boardGamesChanged.subscribe(
      (boardGames: Boardgame[]) => this.boardGames = boardGames
    );
  }

  ngAfterViewInit(): void {
    this.storeService.fetchData();
  }


}


