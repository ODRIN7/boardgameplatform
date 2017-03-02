import {Component, OnInit} from "@angular/core";
import {Message} from "../../../../shared/domain/message";
import {User} from "../../../../shared/domain/user";

@Component({
  inputs: ['message'],
  selector: 'chat-message',
  templateUrl: './chat.message.html',
  styleUrls: ['./chat.message.scss'],
})
export class ChatMessage implements OnInit {
  message: Message;
  currentUser: User;
  incoming: boolean;

  constructor() {
  }

  ngOnInit(): void {
  }
}
