import {Component} from "@angular/core";
import {Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {MdSnackBar} from "@angular/material";
import {TdLoadingService, TdDialogService, TdMediaService} from "@covalent/core";
import {AuthService} from "../../shared/services/auth/auth.services";
import {User} from "../../shared/domain/user";


@Component({
  selector: 'bga-users-main',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
})
export class UsersComponent {

  users: User[];
  filteredUsers: User[];

  constructor(private _titleService: Title,
              private _router: Router,
              private _loadingService: TdLoadingService,
              private _dialogService: TdDialogService,
              private _snackBarService: MdSnackBar,
              private _usersService: AuthService,
              public media: TdMediaService) {
  }

  goBack(route: string): void {
    window.history.back();
  }

  ngAfterViewInit(): void {
    // broadcast to all listener observables when loading the page
    this.media.broadcast();

    this._titleService.setTitle( 'Covalent Users' );
    this.loadUsers();
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
