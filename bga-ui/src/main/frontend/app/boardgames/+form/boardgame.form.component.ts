import {Component, AfterViewInit} from "@angular/core";
import {Router, ActivatedRoute} from "@angular/router";
import {TdMediaService} from "@covalent/core";
import {BoardGameType} from "../../shared/domain/boardGame.type";
import {BoardGame} from "../../shared/domain/boardgamee";
import {BoardGameService} from "../../shared/services/boardGame.service";
import {BGtypeBoxParamObj} from "./typeBoxParamObj";


@Component({
  selector: 'bga-boardgames-admin-form',
  templateUrl: './boardgame.form.component.html',
  styleUrls: ['./boardgame.form.component.scss'],
})
export class BoardGameFormComponent implements AfterViewInit {

  public boardGame: BoardGame;
  public fileSelectMsg: String = 'No file selected yet.';
  public fileUploadMsg: String = 'No file uploaded yet.';
  public disabled: boolean = false;
  public allBoardGameTypes: Array<BGtypeBoxParamObj>;
  private action: string;
  private boardGameid: number

  constructor(public router: Router,
              private _route: ActivatedRoute,
              private boardGameService: BoardGameService,
              public media: TdMediaService) {
  }

  ngOnInit(): void {
    this._route.url.subscribe((url: any) => {
      this.action = (url.length > 1 ? url[1].path : 'add');
    });
    this.addPageInit();
    if (this.action != 'add') {
      this._route.params.subscribe((params: {id: string}) => {
        this.boardGameid = +params.id;
      });
    }
    else if (this.action == 'add') {
      this.initBoardGameTypes()
    }
  }

  ngAfterViewInit(): void {
    this.media.broadcast();
    if (this.action != 'add') {
      this.boardGameService.getBoardGameById(this.boardGameid).subscribe((boardgame: BoardGame) => {
        if (boardgame) {
          this.boardGame = boardgame;
          this.initBoardGameTypes();
        }
      });
    }

  }

  private initBoardGameTypes(): void {
    this.allBoardGameTypes = [];
    var options: string[] = Object.keys(BoardGameType);
    options = options.slice(options.length / 2);
    for (var i = 0; i < options.length; i++) {
      this.allBoardGameTypes.push(new BGtypeBoxParamObj(options[i], this.isChecked(options[i])));
    }
  }

  private  addPageInit(): void {
    var id: number = Math.floor(Math.random() * (3000 - 2000));
    this.boardGame = new BoardGame(id, "http://lorempixel.com/40/40/people/7", "http://lorempixel.com/40/40/people/7", [], "", [], "", 1000);
    this.fileUploadMsg = this.boardGame.icon;
    this.fileSelectMsg = this.boardGame.icon;
  }

  private isChecked(boardGameType: string): boolean {
    return this.boardGame.typeOfBoardGames.indexOf(boardGameType) >= 0;
  }

  public checkk(bGtypeBoxParamObj: BGtypeBoxParamObj): void {
    if (bGtypeBoxParamObj.checked) {
      this.boardGame.typeOfBoardGames
        .splice(this.boardGame.typeOfBoardGames.indexOf(bGtypeBoxParamObj.name), 1);
      bGtypeBoxParamObj.checked = false;
    }
    else if (!bGtypeBoxParamObj.checked) {
      this.boardGame.typeOfBoardGames.push(bGtypeBoxParamObj.name);
      bGtypeBoxParamObj.checked = true;
    }
  }

  private setcheckedType(): void {
    this.boardGame.typeOfBoardGames = [];
    for (var i = 0; i < this.allBoardGameTypes.length; i++) {
      if (this.allBoardGameTypes[i].checked) {
        this.boardGame.typeOfBoardGames.push(this.allBoardGameTypes[i].name);
      }
    }
  }

  public save(): void {
    this.setcheckedType();
    if(this.action == 'add'){
      this.boardGameService.create(this.boardGame);
    }
    else {
      this.boardGameService.edit(this.boardGame).subscribe((data) => { console.log(data); });
    }
    this.router.navigate(['/boardgames']);
  }

  public goBack(): void {
    window.history.back();
  }

  public selectEvent(file: File): void {
    this.fileSelectMsg = file.name;
  };

  public uploadEvent(file: File): void {
    this.fileUploadMsg = file.name;
  };

  public toggleDisabled(): void {
    this.disabled = !this.disabled;
  }


}

