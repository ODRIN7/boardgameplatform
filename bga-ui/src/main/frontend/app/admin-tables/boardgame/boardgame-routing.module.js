"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var router_1 = require('@angular/router');
var user_component_1 = require('./user.component');
var ng_module_1 = require('@angular/core/src/metadata/ng_module');
exports.routes = [
    {
        path: 'users',
        pathMatch: 'full',
        component: user_component_1.UserComponent
    }
];
var USER_MODULE = (function () {
    function USER_MODULE() {
    }
    USER_MODULE = __decorate([
        ng_module_1.NgModule({
            imports: [router_1.RouterModule.forChild(exports.routes)],
            exports: [router_1.RouterModule],
            providers: []
        })
    ], USER_MODULE);
    return USER_MODULE;
}());
exports.USER_MODULE = USER_MODULE;
