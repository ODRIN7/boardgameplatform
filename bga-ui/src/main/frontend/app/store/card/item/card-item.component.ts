import { Component, Input } from '@angular/core';
import {Boardgame} from "../../../shared/domain/boardgame";


@Component({
  selector: 'bga-card-item',
  templateUrl: 'card-item.component.html'
})
export class CardItemComponent {
  @Input() boardGame: Boardgame;
  @Input() boardGameId: number;
}
