import {Injectable, EventEmitter} from "@angular/core";
import {Message} from "../domain/message";
import {Http} from "@angular/http";

@Injectable()
export class MessagesService {

  public messageChanged = new EventEmitter<Message[]>();
  public messages: Message[];

  constructor(public http: Http) {

  }

  getMessage(id: number) {
    return this.messageChanged[id];
  }
  sendMessage(message:Message) {
    this.messages.push(message);
  }
  fetchData() {

    this.messages = [];

    this.messages.push(new Message(new Date(), "text1"));
    this.messages.push(new Message(new Date(), "text2"));
    this.messages.push(new Message(new Date(), "text3"));
    this.messages.push(new Message(new Date(), "text4"));
    this.messages.push(new Message(new Date(), "text5"));
    this.messages.push(new Message(new Date(), "text6"));
    this.messages.push(new Message(new Date(), "text7"));
    this.messages.push(new Message(new Date(), "text8"));
    this.messages.push(new Message(new Date(), "text9"));
    this.messages.push(new Message(new Date(), "text10"));
    this.messages.push(new Message(new Date(), "text11"));
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
