import {Injectable, EventEmitter} from "@angular/core";
import {Http, Response} from "@angular/http";
import {User} from "../domain/user";
import {Observable} from "rxjs";
import {BoardGame} from "../domain/boardgamee";


@Injectable()
export class UserService {
  private usersUrl = '/oauth/users/';
  private boardGameURL = 'http://192.168.99.101:8090/api/boardgames/';
  public userChanged = new EventEmitter<User[]>();
  public users: User[];

  constructor(public http: Http) {

  }

  public getUsers() {// Observable<User[]> {
    return null;
    // return this.http.get(this.usersUrl)
    //   .map((response: Response) => response.json())
    //   .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  public getBoardGames(): Observable<BoardGame[]> {
    return this.http.get(this.boardGameURL)
      .map((response: Response) => response.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }


  fetchData() {

    this.users = [];

    this.users.push(new User("user1", "pass1"));
    this.users.push(new User("user2", "pass1"));
    this.users.push(new User("user3", "pass1"));
    this.users.push(new User("user4", "pass1"));
    this.users.push(new User("user5", "pass1"));
    this.users.push(new User("user6", "pass1"));
    this.users.push(new User("user7", "pass1"));
    this.users.push(new User("user8", "pass1"));
    this.users.push(new User("user9", "pass1"));
    this.users.push(new User("user10", "pass1"));
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
