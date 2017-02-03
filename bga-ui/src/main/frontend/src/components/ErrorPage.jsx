"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var ErrorPage = (function (_super) {
    __extends(ErrorPage, _super);
    function ErrorPage() {
        _super.call(this);
        this.state = {};
    }
    ErrorPage.prototype.componentDidMount = function () {
        var _this = this;
        fetch('http://localhost:8080/api/oups')
            .then(function (response) { return response.json(); })
            .then(function (error) { return _this.setState({ error: error }); });
    };
    ErrorPage.prototype.render = function () {
        var error = this.state.error;
        return <span>
      <img src='public/images/pets.png'/>

      <h2>Something happened...</h2>
      {error ?
            <span>
          <p><b>Status:</b> {error.status}</p>
          <p><b>Message:</b> {error.message}</p>
        </span>
            :
                <p><b>Unkown error</b></p>}
    </span>;
    };
    return ErrorPage;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = ErrorPage;
;
