"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var util_1 = require('../../util');
var LoadingPanel_1 = require('./LoadingPanel');
var PetEditor_1 = require('./PetEditor');
var createPetEditorModel_1 = require('./createPetEditorModel');
;
var EditPetPage = (function (_super) {
    __extends(EditPetPage, _super);
    function EditPetPage() {
        _super.apply(this, arguments);
    }
    EditPetPage.prototype.componentDidMount = function () {
        var _this = this;
        var params = this.props.params;
        var fetchUrl = util_1.url("/api/owners/" + params.ownerId + "/pets/" + params.petId);
        var loadPetPromise = fetch(fetchUrl).then(function (response) { return response.json(); });
        createPetEditorModel_1.default(this.props.params.ownerId, loadPetPromise)
            .then(function (model) { return _this.setState(model); });
    };
    EditPetPage.prototype.render = function () {
        if (!this.state) {
            return <LoadingPanel_1.default />;
        }
        return <PetEditor_1.default {...this.state}/>;
    };
    return EditPetPage;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = EditPetPage;
