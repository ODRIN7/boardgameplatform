import {Component} from '@angular/core';
import {MessagesService} from "../../../shared/services/MessagesService";
import {ThreadsService} from "../../../shared/services/ThreadsService";
import {UserService} from "../../../shared/services/UserService";
import {ChatExampleData} from "../../../shared/domain/ChatExampleData";

@Component({
  selector: 'bga-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
})
export class ChatComponent {
  constructor(public messagesService: MessagesService,
              public threadsService: ThreadsService,
              public userService: UserService) {
    ChatExampleData.init(messagesService, threadsService, userService);
  }
}


