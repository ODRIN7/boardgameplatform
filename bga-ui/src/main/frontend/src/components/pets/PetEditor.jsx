"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var util_1 = require('../../util');
var Input_1 = require('../form/Input');
var DateInput_1 = require('../form/DateInput');
var SelectInput_1 = require('../form/SelectInput');
;
var PetEditor = (function (_super) {
    __extends(PetEditor, _super);
    function PetEditor(props) {
        _super.call(this, props);
        this.onInputChange = this.onInputChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.state = { editablePet: Object.assign({}, props.pet) };
    }
    PetEditor.prototype.onSubmit = function (event) {
        var _this = this;
        event.preventDefault();
        var owner = this.props.owner;
        var editablePet = this.state.editablePet;
        var request = {
            birthDate: editablePet.birthDate,
            name: editablePet.name,
            typeId: editablePet.typeId
        };
        var url = editablePet.isNew ? '/api/owners/' + owner.id + '/pets' : '/api/owners/' + owner.id + '/pets/' + editablePet.id;
        util_1.submitForm(editablePet.isNew ? 'POST' : 'PUT', url, request, function (status, response) {
            if (status === 204) {
                _this.context.router.push({
                    pathname: '/owners/' + owner.id
                });
            }
            else {
                console.log('ERROR?!...', response);
                _this.setState({ error: response });
            }
        });
    };
    PetEditor.prototype.onInputChange = function (name, value) {
        var editablePet = this.state.editablePet;
        var modifiedPet = Object.assign({}, editablePet, (_a = {}, _a[name] = value, _a));
        this.setState({ editablePet: modifiedPet });
        var _a;
    };
    PetEditor.prototype.render = function () {
        var _a = this.props, owner = _a.owner, pettypes = _a.pettypes;
        var _b = this.state, editablePet = _b.editablePet, error = _b.error;
        var formLabel = editablePet.isNew ? 'Add Pet' : 'Update Pet';
        return (<span>
        <h2>{formLabel}</h2>
        <form className='form-horizontal' method='POST' action={util_1.url('/api/owner')}>
          <div className='form-group has-feedback'>
            <div className='form-group'>
              <label className='col-sm-2 control-label'>Owner</label>
              <div className='col-sm-10'>{owner.firstName} {owner.lastName}</div>
            </div>

            <Input_1.default object={editablePet} error={error} label='Name' name='name' onChange={this.onInputChange}/>
            <DateInput_1.default object={editablePet} error={error} label='Birth date' name='birthDate' onChange={this.onInputChange}/>
            <SelectInput_1.default object={editablePet} error={error} label='Type' name='typeId' options={pettypes} onChange={this.onInputChange}/>
          </div>
          <div className='form-group'>
            <div className='col-sm-offset-2 col-sm-10'>
              <button className='btn btn-default' type='submit' onClick={this.onSubmit}>{formLabel}</button>
            </div>
          </div>
        </form>
      </span>);
    };
    PetEditor.contextTypes = {
        router: React.PropTypes.object.isRequired
    };
    return PetEditor;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = PetEditor;
