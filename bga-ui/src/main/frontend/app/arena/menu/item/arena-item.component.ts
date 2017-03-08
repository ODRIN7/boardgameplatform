import {Component, Input, HostBinding} from "@angular/core";
import {Router} from "@angular/router";
import {slideInDownAnimation} from "../../../app.animations";
import {Boardgame} from "../../../shared/domain/boardgame";


@Component({
  selector: 'bga-arena-item',
  templateUrl: 'arena-item.component.html',
  animations: [slideInDownAnimation],
})
export class ArenaItemComponent {
  @Input() boardGame: Boardgame;
  @Input() boardGameId: number;
  @HostBinding('@routeAnimation') routeAnimation: boolean = true;
  @HostBinding('class.td-route-animation') classAnimation: boolean = true;


  constructor(public router: Router) {

  }

  expandCollapseExpansion1Msg: string = 'No expanded/collapsed detected yet';
  expansion1: boolean = false;
  disabled: boolean = false;

  toggleExpansion1(): void {
    if (!
        this.disabled
    ) {
      this.expansion1 = !this.expansion1;
    }
  }

  toggleDisabled(): void {
    this.disabled = !this.disabled;
  }

  expandExpansion1Event(): void {
    this.expandCollapseExpansion1Msg = 'Expand event emitted.';
  }

  collapseExpansion1Event(): void {
    this.expandCollapseExpansion1Msg = 'Collapse event emitted.';
  }

  onPlay(): void {
    this.router.navigate(["arena/" + this.boardGameId]);
  }
  createNewGame(): void {
    this.router.navigate(["arena/" + this.boardGameId]);
  }

}
