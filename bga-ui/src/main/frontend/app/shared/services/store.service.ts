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

    this.boardGames = [];

    this.boardGames.push(new Boardgame("id1", "text1"));
    this.boardGames.push(new Boardgame("id2", "text2"));
    this.boardGames.push(new Boardgame("id3", "text3"));
    this.boardGames.push(new Boardgame("id4", "text4"));
    this.boardGames.push(new Boardgame("id5", "text5"));
    this.boardGames.push(new Boardgame("id6", "text6"));
    this.boardGames.push(new Boardgame("id7", "text6"));
    this.boardGames.push(new Boardgame("id8", "text6"));
    this.boardGames.push(new Boardgame("id9", "text6"));
    this.boardGames.push(new Boardgame("id6", "text6"));
    /* return this.http.get('/api/boardgames/')
       .map((response: Response) => response.json())
       .subscribe(
         (data: Boardgame[]) => {
           this.boardGames = data;
           this.boardGamesChanged.emit(this.boardGames);
         }
       );*/
  }
}
