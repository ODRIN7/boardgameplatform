import {Component, OnInit, AfterViewInit} from '@angular/core';
import {Boardgame} from "../../shared/domain/boardgame";
import {StoreService} from "../../shared/services/store.service";

@Component({
  selector: 'bga-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.scss'],
})
export class FavouriteComponent implements OnInit, AfterViewInit{

  public openGames: Boardgame[];

  constructor(public storeService: StoreService) {

  }

  ngOnInit(): void {
    this.openGames = this.storeService.boardGames;
    this.storeService.boardGamesChanged.subscribe(
      (boardGames: Boardgame[]) => this.openGames = boardGames
    );
  }

  ngAfterViewInit(): void {
    this.storeService.fetchData();
  }

}

