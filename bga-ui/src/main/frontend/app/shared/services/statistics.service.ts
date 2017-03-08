import {Injectable, EventEmitter} from "@angular/core";
import {Http} from "@angular/http";
import {User} from "../domain/user";


@Injectable()
export class StatisticsService {
  public userChanged = new EventEmitter<User[]>();
  public users: User[];

  constructor(public http: Http) {

  }

  getBoardGame(id: number) {
    return this.users[id];
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
