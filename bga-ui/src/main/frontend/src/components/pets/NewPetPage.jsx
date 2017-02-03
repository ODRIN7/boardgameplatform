"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var LoadingPanel_1 = require('./LoadingPanel');
var PetEditor_1 = require('./PetEditor');
var createPetEditorModel_1 = require('./createPetEditorModel');
;
var NEW_PET = {
    id: null,
    isNew: true,
    name: '',
    birthDate: null,
    typeId: null
};
var NewPetPage = (function (_super) {
    __extends(NewPetPage, _super);
    function NewPetPage() {
        _super.apply(this, arguments);
    }
    NewPetPage.prototype.componentDidMount = function () {
        var _this = this;
        createPetEditorModel_1.default(this.props.params.ownerId, Promise.resolve(NEW_PET))
            .then(function (model) { return _this.setState(model); });
    };
    NewPetPage.prototype.render = function () {
        if (!this.state) {
            return <LoadingPanel_1.default />;
        }
        return <PetEditor_1.default {...this.state}/>;
    };
    return NewPetPage;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = NewPetPage;
