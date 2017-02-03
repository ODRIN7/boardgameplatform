"use strict";
var React = require('react');
var react_router_1 = require('react-router');
var App_1 = require('./components/App');
var WelcomePage_1 = require('./components/WelcomePage');
var FindOwnersPage_1 = require('./components/owners/FindOwnersPage');
var OwnersPage_1 = require('./components/owners/OwnersPage');
var NewOwnerPage_1 = require('./components/owners/NewOwnerPage');
var EditOwnerPage_1 = require('./components/owners/EditOwnerPage');
var NewPetPage_1 = require('./components/pets/NewPetPage');
var EditPetPage_1 = require('./components/pets/EditPetPage');
var VisitsPage_1 = require('./components/visits/VisitsPage');
var VetsPage_1 = require('./components/vets/VetsPage');
var ErrorPage_1 = require('./components/ErrorPage');
var NotFoundPage_1 = require('./components/NotFoundPage');
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function () { return (<react_router_1.Route component={App_1.default}>
    <react_router_1.Route path='/' component={WelcomePage_1.default}/>
    <react_router_1.Route path='/owners/list' component={FindOwnersPage_1.default}/>
    <react_router_1.Route path='/owners/new' component={NewOwnerPage_1.default}/>
    <react_router_1.Route path='/owners/:ownerId/edit' component={EditOwnerPage_1.default}/>
    <react_router_1.Route path='/owners/:ownerId/pets/:petId/edit' component={EditPetPage_1.default}/>
    <react_router_1.Route path='/owners/:ownerId/pets/new' component={NewPetPage_1.default}/>
    <react_router_1.Route path='/owners/:ownerId/pets/:petId/visits/new' component={VisitsPage_1.default}/>
    <react_router_1.Route path='/owners/:ownerId' component={OwnersPage_1.default}/>
    <react_router_1.Route path='/vets' component={VetsPage_1.default}/>
    <react_router_1.Route path='/error' component={ErrorPage_1.default}/>
    <react_router_1.Route path='*' component={NotFoundPage_1.default}/>
  </react_router_1.Route>); };
