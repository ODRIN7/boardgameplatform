import {Boardgame} from "./boardgame";
export class User {

  private username: string;
  private password: string;
  private authorities: Array<string>
  private boardgames: Array<Boardgame>;


  constructor(username: string, password: string) {
    this.username = username;
    this.password = password;
    this.authorities = [];
    this.boardgames = new Array;
  }

  public addBoardGame(boardgame: Boardgame): void {
    this.boardgames.push(boardgame);
  }

  public static toUser( userData: any): User{
     return new User(
       (userData)['user_name'],
       (userData)['authorities']);
  }

  getusername(): string {
    return this.username;
  }

  setusername(value: string) {
    this.username = value;
  }

  getboardgames(): Array<Boardgame> {
    return this.boardgames;
  }

  getauthorities(): Array<string> {
    return this.authorities;
  }

  setauthorities(value: Array<string>) {
    this.authorities = value;
  }
}
