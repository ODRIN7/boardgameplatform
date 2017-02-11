"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/* tslint:disable:no-unused-variable */
var core_1 = require('@angular/core');
var UserComponent = (function () {
    function UserComponent(http, authService) {
        this.http = http;
        this.authService = authService;
        this.posts = [];
        this.editing = false;
        this.editedPost = null;
    }
    UserComponent.prototype.ngOnInit = function () {
        console.log('hello `Crud` component');
        this.fetchPosts();
    };
    UserComponent.prototype.editPost = function (post) {
        this.editing = true;
        this.editedPost = JSON.parse(JSON.stringify(post));
        this.scrollToTop();
    };
    UserComponent.prototype.newPost = function () {
        this.editing = true;
        this.editedPost = {
            id: null,
            title: '',
            content: '',
            createdDate: null,
            updatedDate: null,
            version: null,
            createdBy: null,
            updatedBy: null,
        };
    };
    UserComponent.prototype.removePost = function (post) {
        this.deletePost(post);
    };
    UserComponent.prototype.cancelEdit = function () {
        this.editing = false;
        this.editedPost = null;
        this.scrollToTop();
    };
    UserComponent.prototype.refresh = function () {
        this.cancelEdit();
        this.fetchPosts();
    };
    UserComponent.prototype.fetchPosts = function () {
        var _this = this;
        this.http.get('/api/posts/', { headers: this.authService.getAuthorizationHeaders() })
            .subscribe(function (data) {
            _this.posts = data.json();
        }, function (err) { return console.log('Something went wrong'); });
    };
    UserComponent.prototype.savePost = function (post) {
        var _this = this;
        this.http.post("/api/posts/", post, { headers: this.authService.getAuthorizationHeaders() })
            .subscribe(function (data) {
            console.log('Saved', data.json());
            _this.updateOrAddPostToList(data.json());
        }, function (err) { return console.log('Something went wrong'); });
    };
    UserComponent.prototype.deletePost = function (post) {
        var _this = this;
        this.http.delete("/api/posts/" + post.id, { headers: this.authService.getAuthorizationHeaders() })
            .subscribe(function (data) {
            console.log('Removed', data.json());
            _this.removePostFromList(post);
        }, function (err) { return console.log('Something went wrong'); });
    };
    UserComponent.prototype.removePostFromList = function (post) {
        this.posts = this.posts.filter(function (x, idx, obs) { return x.id !== post.id; });
        this.cancelEdit();
    };
    UserComponent.prototype.updateOrAddPostToList = function (post) {
        var _this = this;
        var changedList = this.posts.filter(function (x, idx, obs) { return x.id === post.id; });
        if (changedList.length === 0) {
            this.posts.push(post);
        }
        else {
            changedList.forEach(function (x) {
                var index = _this.posts.indexOf(x);
                _this.posts[index] = post;
            });
        }
        this.cancelEdit();
    };
    UserComponent.prototype.scrollToTop = function () {
        var contentEl = document.querySelector('md-sidenav-layout > md-content');
        if (contentEl) {
            this.scrollTo(contentEl, 0, 100);
        }
    };
    UserComponent.prototype.scrollTo = function (element, to, duration) {
        var _this = this;
        if (duration <= 0) {
            return;
        }
        var difference = to - element.scrollTop;
        var perTick = difference / duration * 10;
        setTimeout(function () {
            element.scrollTop = element.scrollTop + perTick;
            if (element.scrollTop === to) {
                return;
            }
            _this.scrollTo(element, to, duration - 10);
        }, 10);
    };
    UserComponent = __decorate([
        core_1.Component({
            selector: 'bga-users',
            templateUrl: './user.component.html',
            styleUrls: ['./user.component.scss']
        })
    ], UserComponent);
    return UserComponent;
}());
exports.UserComponent = UserComponent;
