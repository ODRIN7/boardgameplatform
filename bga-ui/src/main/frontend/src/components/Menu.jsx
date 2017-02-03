"use strict";
var React = require('react');
var MenuItem = function (_a) {
    var active = _a.active, url = _a.url, title = _a.title, children = _a.children;
    return (<li className={active ? 'active' : ''}>
    <a href={url} title={title}>{children}</a>
  </li>);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var name = _a.name;
    return (<nav className='navbar navbar-default' role='navigation'>
    <div className='container'>
      <div className='navbar-header'>
        <a className='navbar-brand' href='/'><span></span></a>
        <button type='button' className='navbar-toggle' data-toggle='collapse' data-target='#main-navbar'>
          <span className='icon-bar'></span>
          <span className='icon-bar'></span>
          <span className='icon-bar'></span>
        </button>
      </div>
      <div className='navbar-collapse collapse' id='main-navbar'>
        <ul className='nav navbar-nav navbar-right'>
          <MenuItem active={name === '/'} url='/' title='home page'>
            <span className='glyphicon glyphicon-home' aria-hidden='true'></span>&nbsp;
                    <span>Home</span>
          </MenuItem>

          <MenuItem active={name.startsWith('/owners')} url='/owners/list' title='find owners'>
            <span className='glyphicon glyphicon-search' aria-hidden='true'></span>&nbsp;
                    <span>Find owners</span>
          </MenuItem>

          <MenuItem active={name === 'vets'} url='/vets' title='veterinarians'>
            <span className='glyphicon glyphicon-th-list' aria-hidden='true'></span>&nbsp;
                    <span>Veterinarians</span>
          </MenuItem>

          <MenuItem active={name === 'error'} url='/error' title='trigger a RuntimeException to see how it is handled'>
            <span className='glyphicon glyphicon-warning-sign' aria-hidden='true'></span>&nbsp;
                    <span>Error</span>
          </MenuItem>
        </ul>
      </div>
    </div>
  </nav>);
};
