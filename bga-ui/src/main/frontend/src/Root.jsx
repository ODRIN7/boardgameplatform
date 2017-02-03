"use strict";
var React = require('react');
var Router = require('react-router').Router;
// Routes
var configureRoutes_1 = require('./configureRoutes');
// https://github.com/gaearon/react-hot-boilerplate/pull/61#issuecomment-218333616
// https://github.com/rybon/counter-hmr/blob/e651ce25b3a307f13ca53c977f9e8709ba873407/src/components/Root.jsx
var Root = function (_a) {
    var history = _a.history;
    return (<Router history={history}>
      {configureRoutes_1.default()}
  </Router>);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = Root;
