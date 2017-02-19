import {Boardgame} from "./boardgame";
import {Role} from "./roles";
import {User} from "./user";
import {Status} from "./Status";
export class Shopping {

  private id: Number;
  private boardGame: Boardgame;
  private user: User;
  private creationDate: Date;
  private status: Status;


  constructor(id: Number, boardGame: Boardgame, user: User, status: Status) {
    this.id = id;
    this.boardGame = boardGame;
    this.user = user;
    this.status = status;
  }

}
