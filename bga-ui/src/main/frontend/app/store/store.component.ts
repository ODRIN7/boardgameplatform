import {Component, AfterViewInit, OnInit} from "@angular/core";
import {TdMediaService, TdDialogService, TdLoadingService} from "@covalent/core";
import {Boardgame} from "../shared/domain/boardgame";
import {StoreService} from "../shared/services/store.service";
import {AuthService} from "../shared/services/auth/auth.services";
import {MdSnackBar} from "@angular/material";
import {Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {User} from "../shared/domain/user";

@Component({
  selector: 'bga-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss'],
})
export class StoreComponent implements AfterViewInit, OnInit {
  ngOnInit(): void {
    this.boardGames = this.storeService.boardGames;
    this.shoppingCard = this.storeService.boardGames;
  }


  public boardGames: Boardgame[];
  public shoppingCard: Boardgame[];
  users: User[];
  filteredUsers: User[];

  constructor(public storeService: StoreService,
              public authService: AuthService,
              public _titleService: Title,
              public _router: Router,
              public _loadingService: TdLoadingService,
              public _dialogService: TdDialogService,
              public _snackBarService: MdSnackBar,
              public _usersService: AuthService,
              public media: TdMediaService) {
  }

  goBack(route: string): void {
    window.history.back();
  }

  ngAfterViewInit(): void {
    // broadcast to all listener observables when loading the page
    this.media.broadcast();

    this._titleService.setTitle('Covalent Users');
    this.loadUsers();
    this.boardGames = this.storeService.boardGames;
    this.storeService.boardGamesChanged.subscribe(
      (boardGames: Boardgame[]) => this.boardGames = boardGames
    );
    this.shoppingCard = this.storeService.boardGames;
    this.storeService.boardGamesChanged.subscribe(
      (boardGames: Boardgame[]) => this.boardGames = boardGames
    );
  }

  public filterAllUsers(displayName: string = ''): void {
    /* this.filteredUsers = this.users.filter((user: User) => {
     return user.getusername().toLowerCase().indexOf(displayName.toLowerCase()) > -1;
     });*/
  }

  public filterUsers(): void {
  }

  loadUsers(): void {

    this.filteredUsers = [];
    this.filteredUsers = this._usersService.getUsers();
    /*  this._loadingService.register('users.list');
     this._usersService.getUsers().subscribe((users: User[]) => {
     this.users = users;
     this.filteredUsers = users;
     this._loadingService.resolve('users.list');
     }, (error: Error) => {
     this._usersService.getUsers().subscribe((users: User[]) => {
     this.users = users;
     this.filteredUsers = users;
     this._loadingService.resolve('users.list');
     });
     });*/
  }

  deleteUser(id: string): void {
    this._dialogService
      .openConfirm({message: 'Are you sure you want to delete this user?'})
    /* .afterClosed().subscribe((confirm: boolean) => {
     if (confirm) {
     this._loadingService.register('users.list');
     this._usersService.delete(id).subscribe(() => {
     this.users = this.users.filter((user: User) => {
     return user.getusername() !== id;
     });
     this.filteredUsers = this.filteredUsers.filter((user: User) => {
     return user.getusername() !== id;
     });
     this._loadingService.resolve('users.list');
     this._snackBarService.open('User deleted', 'Ok');
     }, (error: Error) => {
     this._dialogService.openAlert({message: 'There was an error'});
     this._loadingService.resolve('users.list');
     });
     }
     });*/
  }
}
