import {ChangeDetectionStrategy, ElementRef, Component, OnInit} from "@angular/core";
import {Message} from "../../../../shared/domain/message";
import {User} from "../../../../shared/domain/user";
import {MessagesService} from "../../../../shared/services/messages.service";


@Component({
  selector: 'chat-window',
  templateUrl: './chat.window.html',
  styleUrls: ['./chat.window.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class ChatWindow implements OnInit {
  messages: Message[];
  draftMessage: Message;
  currentUser: User;

  constructor(public messagesService: MessagesService,
              public el: ElementRef) {
  }

  ngOnInit(): void {
    this.draftMessage = new Message(new Date(), "");

    this.messagesService.fetchData();
    this.messages = this.messagesService.messages ;
  }

  onEnter(event: any): void {
    this.sendMessage();
    event.preventDefault();
  }

  sendMessage(): void {
       this.messagesService.sendMessage(this.draftMessage);
  }

  scrollToBottom(): void {
    let scrollPane: any = this.el
      .nativeElement.querySelector('.msg-container-base');
    scrollPane.scrollTop = scrollPane.scrollHeight;
  }

}
