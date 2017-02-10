import {Boardgame} from "./boardgame";
export class User {

  private _username: string;
  private _password: string;
  private _authorities: Array<string>
  private _boardgames: Array<Boardgame>;


  constructor(username: string, password: string, authorities: Array<string>, boardgames: Array<Boardgame>) {
    this._username = username;
    this._password = password;
    this._authorities = authorities;
    this._boardgames = boardgames;
  }

  public addBoardGame(boardgame: Boardgame): void {
    this._boardgames.push(boardgame);
  }

  public static toUser( userData: any): User{
     return new User(
       (userData)['user_name'],
       (userData)['authorities'],
       (userData)['authorities'],
       (userData)['authorities']);
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get boardgames(): Array<Boardgame> {
    return this._boardgames;
  }

  get authorities(): Array<string> {
    return this._authorities;
  }

  set authorities(value: Array<string>) {
    this._authorities = value;
  }
}
