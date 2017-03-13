import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import {BoardGame} from "../domain/boardgamee";


@Injectable()
export class BoardGameService {
  private boardGameURL = '/api/boardgames/';
  private options: RequestOptions;

  constructor(public http: Http) {
  }

  public getBoardGames(): Observable<BoardGame[]> {
    return this.http.get(this.boardGameURL)
      .map((response: Response) => response.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  public getBoardGameById(id: number): Observable<BoardGame> {
    return this.http.get(this.boardGameURL + id)
      .map((response: Response) => response.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  public deleteById(id: number): void{
    // let headers = new Headers({
    //   'Content-Type': 'application/json',
    //   'Access-Control-Allow-Credentials': 'true',
    //   'Access-Control-Allow-Origin': '*'
    // });
    // let options = new RequestOptions({headers: headers});
     this.http.delete(this.boardGameURL + id);

  }

  public create(boardGame: BoardGame): Observable<BoardGame> {
    let bodyString = JSON.stringify(boardGame);
    let headers = new Headers({
      'Content-Type': 'application/json'
    });
    let options = new RequestOptions({headers: headers});

    return this.http.post(this.boardGameURL, boardGame, options)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  public edit(boardGame: BoardGame): Observable<BoardGame> {
    let bodyString = JSON.stringify(boardGame);
    let headers = new Headers({'Content-Type': 'application/json'});

    let options = new RequestOptions({headers: headers});

    return this.http.put(`${this.boardGameURL}/${boardGame['id']}`, boardGame, options)
      .map((res: Response) => res.json());

  }


}
