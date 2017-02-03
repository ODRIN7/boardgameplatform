"use strict";
var React = require('react');
var Menu_1 = require('./Menu');
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var location = _a.location, children = _a.children;
    return (<div>
    <Menu_1.default name={location.pathname}/>
    <div className='container-fluid'>
      <div className='container xd-container'>

        {children}

        <div className='container'>
          <div className='row'>
            <div className='col-12 text-center'>
              <img src='public/images/spring-pivotal-logo.png' alt='Sponsored by Pivotal'/></div>
          </div>
        </div>
      </div>
    </div>
  </div>);
};
