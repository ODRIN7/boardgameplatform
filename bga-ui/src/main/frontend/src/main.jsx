"use strict";
// React and Hot Loader
var React = require('react');
var ReactDOM = require('react-dom');
var react_hot_loader_1 = require('react-hot-loader');
var react_router_1 = require('react-router');
require('../styles/less/petclinic.less');
// The Application
var Root_1 = require('./Root');
// Render Application
var mountPoint = document.getElementById('mount');
ReactDOM.render(<react_hot_loader_1.AppContainer><Root_1.default history={react_router_1.browserHistory}/></react_hot_loader_1.AppContainer>, mountPoint);
if (module.hot) {
    module.hot.accept('./Root', function () {
        var NextApp = require('./Root').default;
        ReactDOM.render(<react_hot_loader_1.AppContainer>
        <NextApp history={react_router_1.browserHistory}/>
      </react_hot_loader_1.AppContainer>, mountPoint);
    });
}
