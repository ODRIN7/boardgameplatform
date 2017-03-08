import {Component, OnInit, AfterViewInit, Input} from '@angular/core';
import {Boardgame} from "../../shared/domain/boardgame";
import {StoreService} from "../../shared/services/store.service";

@Component({
  selector: 'bga-gameboard',
  templateUrl: './gameboard.component.html',
  styleUrls: ['./gameboard.component.scss'],
})
export class GameBoardComponent implements OnInit, AfterViewInit {
  @Input() routing: String;
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


