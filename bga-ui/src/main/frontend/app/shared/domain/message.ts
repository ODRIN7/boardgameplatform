
export class  Message {
  id: string;
  sentAt: Date;
  isRead: boolean;
  text: string;

  constructor(sentAt: Date, text: string) {
    this.sentAt = sentAt;
    this.text = text;
  }
}
