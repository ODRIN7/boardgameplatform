"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var util_1 = require('../../util');
var OwnerInformation_1 = require('./OwnerInformation');
var PetsTable_1 = require('./PetsTable');
var OwnersPage = (function (_super) {
    __extends(OwnersPage, _super);
    function OwnersPage() {
        _super.call(this);
        this.state = {};
    }
    OwnersPage.prototype.componentDidMount = function () {
        var _this = this;
        var params = this.props.params;
        if (params && params.ownerId) {
            var fetchUrl = util_1.url("/api/owner/" + params.ownerId);
            fetch(fetchUrl)
                .then(function (response) { return response.json(); })
                .then(function (owner) { return _this.setState({ owner: owner }); });
        }
    };
    OwnersPage.prototype.render = function () {
        var owner = this.state.owner;
        if (!owner) {
            return <h2>No Owner loaded</h2>;
        }
        return (<span>
        <OwnerInformation_1.default owner={owner}/>
        <PetsTable_1.default owner={owner}/>
      </span>);
    };
    return OwnersPage;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = OwnersPage;
