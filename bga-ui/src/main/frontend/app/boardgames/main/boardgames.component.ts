import {Component, AfterViewInit, EventEmitter, OnChanges} from "@angular/core";
import {Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {MdSnackBar} from "@angular/material";
import {TdLoadingService, TdDialogService, TdMediaService} from "@covalent/core";
import {BoardGame} from "../../shared/domain/boardgamee";
import {BoardGameService} from "../../shared/services/boardGame.service";
import {BoardGameType} from "../../shared/domain/boardGame.type";
import {EmitterService} from "../../shared/services/emitter.service";


@Component({
  selector: 'bga-boardgames-manager',
  templateUrl: './boardgames.component.html',
  styleUrls: ['./boardgames.component.scss'],
})
export class BoardGameManagerComponent implements AfterViewInit, OnChanges {

  boardGames: BoardGame[] = [];
  filteredBoardGames: BoardGame[] = [];
  public allBoardGameTypes: Array<string>;
  private boardGameListId = 'BOARDGAME_COMPONENT'


  constructor(private _titleService: Title,
              private _router: Router,
              private _loadingService: TdLoadingService,
              private _dialogService: TdDialogService,
              private _snackBarService: MdSnackBar,
              private boardGameService: BoardGameService,
              private eventEmitter: EmitterService,
              public media: TdMediaService) {
  }

  goBack(route: string): void {
    window.history.back();
  }

  ngAfterViewInit(): void {
    this.media.broadcast();
    this.initBoardGameTypes();
    this._titleService.setTitle('Covalent Users');
    this.loadBoardGames();
  }

  private initBoardGameTypes(): void {
    this.allBoardGameTypes = Object.keys(BoardGameType);
    this.allBoardGameTypes = this.allBoardGameTypes.slice(this.allBoardGameTypes.length / 2);
  }

  public filterBoardGames(displayName: string = ''): void {
    this.filteredBoardGames = this.boardGames.filter((boardGame: BoardGame) => {
      return boardGame.name.toLowerCase().indexOf(displayName.toLowerCase()) > -1;
    });
  }

  public filterBoardGamesByType(boardGameType: string = ''): void {
    if (boardGameType != '') {
      this.filteredBoardGames = this.boardGames.filter((boardGame: BoardGame) => {
        return boardGame.typeOfBoardGames.indexOf(boardGameType) > -1;
      });
    }
  }

  public filterUsers(): void {
  }

  loadBoardGames(): void {

    this.filteredBoardGames = [];
    this._loadingService.register('boardGames.list');
    this.boardGameService.getBoardGames().subscribe((boardGames: BoardGame[]) => {
      this.boardGames = boardGames;
      this.filteredBoardGames = boardGames;
      this._loadingService.resolve('boardGames.list');
    }, (error: Error) => {
      this.boardGameService.getBoardGames().subscribe((users: BoardGame[]) => {
        this.boardGames = users;
        this.filteredBoardGames = users;
        this._loadingService.resolve('boardGames.list');
      });
    });
  }

  ngOnChanges(changes: any) {
    // Listen to the 'list'emitted event so as populate the model
    // with the event payload
    EmitterService.get(this.boardGameListId).subscribe((boardGames: BoardGame[]) => {
      this.loadBoardGames()
    });
  }

  deleteBoardGame(id: number): void {
    this._dialogService
      .openConfirm({message: 'Are you sure you want to delete this user?'})
      .afterClosed().subscribe((confirm: boolean) => {
      if (confirm) {
        this.boardGameService.deleteById(id);
      }
    });
    EmitterService.get(this.boardGameListId).emit(this.boardGames);
  }
}
