import {Component, Input} from '@angular/core';
import {Boardgame} from "../../../shared/domain/boardgame";


@Component({
  selector: 'bga-opened-game-item',
  templateUrl: 'open-game-item.component.html'
})
export class OpenGameComponent {
  @Input() boardGame: Boardgame;
  @Input() boardGameId: number;
  @Input() routing: String;
}
