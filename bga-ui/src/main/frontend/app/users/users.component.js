"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var services_1 = require("../../services");
var UsersComponent = (function () {
    function UsersComponent(_titleService, _router, _loadingService, _dialogService, _snackBarService, _usersService, media) {
        this._titleService = _titleService;
        this._router = _router;
        this._loadingService = _loadingService;
        this._dialogService = _dialogService;
        this._snackBarService = _snackBarService;
        this._usersService = _usersService;
        this.media = media;
    }
    UsersComponent.prototype.goBack = function (route) {
        this._router.navigate(['/']);
    };
    UsersComponent.prototype.ngAfterViewInit = function () {
        // broadcast to all listener observables when loading the page
        this.media.broadcast();
        this._titleService.setTitle('Covalent Users');
        this.loadUsers();
    };
    UsersComponent.prototype.filterUsers = function (displayName) {
        if (displayName === void 0) { displayName = ''; }
        this.filteredUsers = this.users.filter(function (user) {
            return user.displayName.toLowerCase().indexOf(displayName.toLowerCase()) > -1;
        });
    };
    UsersComponent.prototype.loadUsers = function () {
        var _this = this;
        this._loadingService.register('users.list');
        this._usersService.query().subscribe(function (users) {
            _this.users = users;
            _this.filteredUsers = users;
            _this._loadingService.resolve('users.list');
        }, function (error) {
            _this._usersService.staticQuery().subscribe(function (users) {
                _this.users = users;
                _this.filteredUsers = users;
                _this._loadingService.resolve('users.list');
            });
        });
    };
    UsersComponent.prototype.deleteUser = function (id) {
        var _this = this;
        this._dialogService
            .openConfirm({ message: 'Are you sure you want to delete this user?' })
            .afterClosed().subscribe(function (confirm) {
            if (confirm) {
                _this._loadingService.register('users.list');
                _this._usersService.delete(id).subscribe(function () {
                    _this.users = _this.users.filter(function (user) {
                        return user.id !== id;
                    });
                    _this.filteredUsers = _this.filteredUsers.filter(function (user) {
                        return user.id !== id;
                    });
                    _this._loadingService.resolve('users.list');
                    _this._snackBarService.open('User deleted', 'Ok');
                }, function (error) {
                    _this._dialogService.openAlert({ message: 'There was an error' });
                    _this._loadingService.resolve('users.list');
                });
            }
        });
    };
    return UsersComponent;
}());
UsersComponent = __decorate([
    core_1.Component({
        selector: 'qs-users',
        templateUrl: './users.component.html',
        styleUrls: ['./users.component.scss'],
        viewProviders: [services_1.UsersService],
    })
], UsersComponent);
exports.UsersComponent = UsersComponent;
