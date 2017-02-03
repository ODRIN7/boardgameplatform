"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var OwnerEditor_1 = require('./OwnerEditor');
var util_1 = require('../../util');
var EditOwnerPage = (function (_super) {
    __extends(EditOwnerPage, _super);
    function EditOwnerPage() {
        _super.apply(this, arguments);
    }
    EditOwnerPage.prototype.componentDidMount = function () {
        var _this = this;
        var params = this.props.params;
        if (params && params.ownerId) {
            var fetchUrl = util_1.url("/api/owner/" + params.ownerId);
            fetch(fetchUrl)
                .then(function (response) { return response.json(); })
                .then(function (owner) { return _this.setState({ owner: owner }); });
        }
    };
    EditOwnerPage.prototype.render = function () {
        var owner = this.state && this.state.owner;
        if (owner) {
            return <OwnerEditor_1.default initialOwner={owner}/>;
        }
        return null;
    };
    return EditOwnerPage;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = EditOwnerPage;
