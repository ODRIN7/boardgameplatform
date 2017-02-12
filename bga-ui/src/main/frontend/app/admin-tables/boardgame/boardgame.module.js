"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require('@angular/core');
var user_component_1 = require('./user.component');
var user_routing_module_1 = require('./user-routing.module');
var common_modules_1 = require('../shared/common/common.modules');
var CrudModule = (function () {
    function CrudModule() {
    }
    CrudModule = __decorate([
        core_1.NgModule({
            imports: common_modules_1.COMMON_CHILD_MODULES.concat([
                user_routing_module_1.USER_MODULE
            ]),
            declarations: [user_component_1.UserComponent]
        })
    ], CrudModule);
    return CrudModule;
}());
exports.CrudModule = CrudModule;
