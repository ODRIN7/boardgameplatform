import {Injectable, EventEmitter} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Boardgame} from "../domain/boardgame";


@Injectable()
export class StoreService {
  public boardGamesChanged = new EventEmitter<Boardgame[]>();
  public boardGames: Boardgame[];

  constructor(public http: Http) {

  }

  getBoardGame(id: number) {
    return this.boardGames[id];
  }

  fetchData() {

    return this.http.get('/api/boardgames/')
      .map((response: Response) => response.json())
      .subscribe(
        (data: Boardgame[]) => {
          this.boardGames = data;
          this.boardGamesChanged.emit(this.boardGames);
        }
      );
  }
}
