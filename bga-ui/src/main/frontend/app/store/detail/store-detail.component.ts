import {Component, OnInit} from "@angular/core";
import {Boardgame} from "../../shared/domain/boardgame";
import {TdMediaService} from "@covalent/core";
import {Subscription} from "rxjs/Rx";
import {ActivatedRoute} from "@angular/router";
import {StoreService} from "../../shared/services/storeservice";

@Component({
  selector: 'bga-store-detail',
  templateUrl: './store-detail.component.html',
})
export class StoreDetailComponent implements OnInit {
  public boardGame: Boardgame;
  private boardGameId: number;
  private isNew = true;
  private subscription: Subscription;

  constructor(public media: TdMediaService,
              private route: ActivatedRoute,
              private storeService: StoreService) {

  }

  ngOnInit() {
    this.subscription = this.route.params.subscribe(
      (params: any) => {
        if (params.hasOwnProperty('id')) {
          this.isNew = false;
          this.boardGameId = +params['id'];
          this.boardGame = this.storeService.getBoardGame(this.boardGameId);
        } else {
          this.isNew = true;
          this.boardGame = null;
        }
      }
    );
  }
}
