import {ChangeDetectionStrategy, ElementRef} from "@angular/core";
import {Component, OnInit} from "@angular/core";
import {Observable} from "rxjs";
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
  messages: Observable<any>;
  draftMessage: Message;
  currentUser: User;

  constructor(public messagesService: MessagesService,
              public el: ElementRef) {
  }

  ngOnInit(): void {

    //current user


  }

  onEnter(event: any): void {
    this.sendMessage();
    event.preventDefault();
  }

  sendMessage(): void {
    let m: Message = this.draftMessage;
    m.isRead = true;
    this.messagesService.addMessage(m);
  }

  scrollToBottom(): void {
    let scrollPane: any = this.el
      .nativeElement.querySelector('.msg-container-base');
    scrollPane.scrollTop = scrollPane.scrollHeight;
  }

}
