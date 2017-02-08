"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require('@angular/core');
var LoginComponent = (function () {
    function LoginComponent(authService, router) {
        this.authService = authService;
        this.router = router;
        this.username = 'admin';
        this.password = 'xxxxxx';
        this.message = '';
    }
    LoginComponent.prototype.logMeIn = function () {
        var _this = this;
        console.log('LogMeIn');
        this.authService
            .authenticate(this.username, this.password)
            .catch(function (errorMessage) { return _this.message = errorMessage; })
            .then(function () {
            if (_this.authService.isAuthenticated()) {
                _this.router.navigate(['']);
            }
        });
    };
    LoginComponent.prototype.ngOnInit = function () {
        console.log('hello `Login` component');
    };
    LoginComponent = __decorate([
        core_1.Component({
            selector: 'bga-login',
            templateUrl: './login.component.html',
            styleUrls: ['./login.component.scss']
        })
    ], LoginComponent);
    return LoginComponent;
}());
exports.LoginComponent = LoginComponent;
