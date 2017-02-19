import {Component, HostBinding, Input} from '@angular/core';
import {slideInDownAnimation} from "../app.animations";
import {Boardgame} from "../shared/domain/boardgame";
import {StoreService} from "../shared/services/storeservice";


@Component({
  selector: 'bga-arena',
  templateUrl: './arena.component.html',
  styleUrls: ['./arena.component.scss'],
  animations: [slideInDownAnimation],
})
export class ArenaComponent {

  @HostBinding('@routeAnimation') routeAnimation: boolean = true;
  @HostBinding('class.td-route-animation') classAnimation: boolean = true;
  public boardGames: Boardgame[];

  constructor(public storeService: StoreService) {

  }

  ngOnInit(): void {
    this.boardGames = this.storeService.boardGames;
    this.storeService.boardGamesChanged.subscribe(
      (boardGames: Boardgame[]) => this.boardGames = boardGames
    );
  }

  ngAfterViewInit(): void {
    this.storeService.fetchData();
  }


  expandCollapseExpansion1Msg: string = 'No expanded/collapsed detected yet';
  expansion1: boolean = false;
  disabled: boolean = false;

  toggleExpansion1(): void {
    if (!this.disabled) {
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
}
