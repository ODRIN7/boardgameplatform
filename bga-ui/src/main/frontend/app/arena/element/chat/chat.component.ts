import {Component} from "@angular/core";
import {MessagesService} from "../../../shared/services/messages.service";

@Component({
  selector: 'bga-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
})
export class ChatComponent {
  constructor(public messagesService: MessagesService) {
  }
}


