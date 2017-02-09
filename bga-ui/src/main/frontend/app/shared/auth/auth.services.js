"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require('@angular/core');
var http_1 = require('@angular/http');
var AuthServices = (function () {
    function AuthServices(http) {
        this.http = http;
        this.authenticated = false;
        this.tokenExpirationDate = null;
        this.userData = null;
        this.tokenData = JSON.parse(localStorage.getItem('tokenData'));
        if (this.tokenData && this.tokenData.access_token) {
            this.authenticated = true;
            this.userData = this.tokenData.access_token;
            this.tokenExpirationDate = new Date(this.userData.exp * 1000);
            if (this.authenticated && this.tokenExpirationDate < new Date()) {
                console.log('Session timeout');
                this.logout();
            }
        }
    }
    AuthServices.prototype.isAuthenticated = function () {
        this.checkTokenExpirationDate();
        return this.authenticated;
    };
    AuthServices.prototype.authenticate = function (username, password) {
        var _this = this;
        console.log('Authentication pending...');
        return new Promise(function (resolve, reject) {
            if (!username.trim()) {
                reject('Username cannot be blank');
            }
            if (!password.trim()) {
                reject('Password cannot be blank');
            }
            var basicAuthHeader = 'YXBpLXNlcnZpY2U6';
            var grant_type = 'client_credentials&refresh_token';
            var headers = new http_1.Headers();
            headers.append('Authorization', "Basic  " + basicAuthHeader);
            headers.append('Accept', "application/json");
            headers.append('Content-Type', "application/x-www-form-urlencoded");
            var payload = 'username=' + encodeURIComponent(username) + '&password='
                + encodeURIComponent(password) + '&grant_type=' + grant_type;
            _this.http
                .post('uaa/oauth/token', payload, { headers: headers })
                .subscribe(function (data) {
                _this.tokenData = data.json();
                _this.authenticated = true;
                _this.userData = _this.tokenData.access_token;
                _this.tokenExpirationDate = new Date(_this.userData.exp * 1000);
                resolve('OK');
                localStorage.setItem('tokenData', JSON.stringify(_this.tokenData));
            }, function (err) {
                console.log(err);
                reject('Username and password doesn\'t match');
            });
        });
    };
    AuthServices.prototype.tryCreateUser = function (username, password) {
        var _this = this;
        return new Promise(function (resolve, reject) {
            if (!username.trim()) {
                reject('Username cannot be blank');
            }
            if (!password.trim()) {
                reject('Password cannot be blank');
            }
            var basicAuthHeader = btoa("acme:acmesecret");
            var headers = new http_1.Headers();
            headers.append('Authorization', "Basic  " + basicAuthHeader);
            headers.append('Accept', "application/json");
            headers.append('Content-Type', "application/x-www-form-urlencoded");
            var payload = 'username=' + encodeURIComponent(username) + '&password='
                + encodeURIComponent(password) + '&grant_type=password';
            _this.http
                .post('/oauth/**', payload, { headers: headers })
                .subscribe(function (data) {
                _this.tokenData = data.json();
                _this.authenticated = true;
                _this.userData = _this.tokenData.access_token;
                _this.tokenExpirationDate = new Date(_this.userData.exp * 1000);
                resolve('OK');
                localStorage.setItem('tokenData', JSON.stringify(_this.tokenData));
            }, function (err) {
                console.log(err);
                reject('Username and password doesn\'t match');
            });
        });
    };
    AuthServices.prototype.refreshToken = function () {
        var _this = this;
        if (this.isAuthenticated()) {
            var basicAuthHeader = btoa("acme:acmesecret");
            var headers = new http_1.Headers();
            headers.append('Authorization', "Basic  " + basicAuthHeader);
            headers.append('Accept', "application/json");
            headers.append('Content-Type', "application/x-www-form-urlencoded");
            var data = 'grant_type=refresh_token&refresh_token=' + encodeURIComponent(this.tokenData.refresh_token);
            this.http
                .post('/oauth/token', data, { headers: headers })
                .subscribe(function (data) {
                _this.tokenData = data.json();
                _this.authenticated = true;
                _this.userData = _this.tokenData.access_token;
                _this.tokenExpirationDate = new Date(_this.userData.exp * 1000);
            }, function (err) {
                console.log(err);
            });
        }
    };
    AuthServices.prototype.logout = function () {
        this.tokenData = new Oauth2TokenData();
        this.userData = null;
        this.authenticated = false;
        this.tokenExpirationDate = null;
    };
    AuthServices.prototype.getUserData = function () {
        return this.userData;
    };
    AuthServices.prototype.getTokenExpirationDate = function () {
        return this.tokenExpirationDate;
    };
    AuthServices.prototype.hasRole = function (role) {
        if (this.isAuthenticated()) {
            return this.getUserData()['authorities'].indexOf(role) >= 0;
        }
        return false;
    };
    AuthServices.prototype.hasAnyRole = function (roles) {
        var _this = this;
        var ok = false;
        roles.forEach(function (role) {
            if (_this.hasRole(role)) {
                ok = true;
            }
        });
        return ok;
    };
    // public canView(view: AppMenuItem): boolean {
    //   let ok = false;
    //   if (!view.roles) {
    //    ok = true;
    //  } else {
    //    ok = this.hasAnyRole(view.roles);
    //  }
    //  return ok;
    // }
    AuthServices.prototype.getAuthorizationHeaders = function () {
        var authorizationHeaders = new http_1.Headers();
        if (this.authenticated) {
            authorizationHeaders.append('Authorization', "Bearer " + this.tokenData.access_token);
        }
        return authorizationHeaders;
    };
    AuthServices.prototype.checkTokenExpirationDate = function () {
        if (this.authenticated && this.tokenExpirationDate < new Date()) {
            console.log('Session timeout');
            this.logout();
        }
    };
    AuthServices = __decorate([
        core_1.Injectable()
    ], AuthServices);
    return AuthServices;
}());
exports.AuthServices = AuthServices;
var Oauth2TokenData = (function () {
    function Oauth2TokenData() {
        this.access_token = null;
        this.token_type = null;
        this.expires_in = null;
        this.scope = null;
        this.jti = null;
        this.refresh_token = null;
    }
    return Oauth2TokenData;
}());
