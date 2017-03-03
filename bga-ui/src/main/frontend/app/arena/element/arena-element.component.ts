import {Component, HostBinding, Input, AfterViewInit, OnInit} from '@angular/core';
import {slideInDownAnimation} from "../../app.animations";
import {Subscription} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {Boardgame} from "../../shared/domain/boardgame";
import {StoreService} from "../../shared/services/store.service";


@Component({
  selector: 'bga-arena-element',
  templateUrl: './arena-element.component.html',
  styleUrls: ['./arena-element.component.scss'],
  animations: [slideInDownAnimation],
})
export class ArenaElementComponent implements AfterViewInit, OnInit{

  private boardGame: Boardgame;
  private boardGameId: number;
  private isNew = true;
  private subscription: Subscription;

  constructor(public storeService: StoreService,
              private route: ActivatedRoute) {

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
        }
      }
    );
  }

  ngAfterViewInit(): void {

  }

  goBack(): void {
    window.history.back();
  }
}
