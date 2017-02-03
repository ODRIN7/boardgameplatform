"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var util_1 = require('../../util');
var Input_1 = require('../form/Input');
var Constraints_1 = require('../form/Constraints');
;
var OwnerEditor = (function (_super) {
    __extends(OwnerEditor, _super);
    function OwnerEditor(props) {
        _super.call(this, props);
        this.onInputChange = this.onInputChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.state = {
            owner: Object.assign({}, props.initialOwner)
        };
    }
    OwnerEditor.prototype.onSubmit = function (event) {
        var _this = this;
        event.preventDefault();
        var owner = this.state.owner;
        var url = owner.isNew ? '/api/owner' : '/api/owner/' + owner.id;
        util_1.submitForm(owner.isNew ? 'POST' : 'PUT', url, owner, function (status, response) {
            if (status === 200 || status === 201) {
                var newOwner = response;
                _this.context.router.push({
                    pathname: '/owners/' + newOwner.id
                });
            }
            else {
                console.log('ERROR?!...', response);
                _this.setState({ error: response });
            }
        });
    };
    OwnerEditor.prototype.onInputChange = function (name, value, fieldError) {
        var _a = this.state, owner = _a.owner, error = _a.error;
        var modifiedOwner = Object.assign({}, owner, (_b = {}, _b[name] = value, _b));
        var newFieldErrors = error ? Object.assign({}, error.fieldErrors, (_c = {}, _c[name] = fieldError, _c)) : (_d = {}, _d[name] = fieldError, _d);
        this.setState({
            owner: modifiedOwner,
            error: { fieldErrors: newFieldErrors }
        });
        var _b, _c, _d;
    };
    OwnerEditor.prototype.render = function () {
        var _a = this.state, owner = _a.owner, error = _a.error;
        return (<span>
        <h2>New Owner</h2>
        <form className='form-horizontal' method='POST' action={util_1.url('/api/owner')}>
          <div className='form-group has-feedback'>
            <Input_1.default object={owner} error={error} constraint={Constraints_1.NotEmpty} label='First Name' name='firstName' onChange={this.onInputChange}/>
            <Input_1.default object={owner} error={error} constraint={Constraints_1.NotEmpty} label='Last Name' name='lastName' onChange={this.onInputChange}/>
            <Input_1.default object={owner} error={error} constraint={Constraints_1.NotEmpty} label='Address' name='address' onChange={this.onInputChange}/>
            <Input_1.default object={owner} error={error} constraint={Constraints_1.NotEmpty} label='City' name='city' onChange={this.onInputChange}/>
            <Input_1.default object={owner} error={error} constraint={Constraints_1.Digits(10)} label='Telephone' name='telephone' onChange={this.onInputChange}/>
          </div>
          <div className='form-group'>
            <div className='col-sm-offset-2 col-sm-10'>
              <button className='btn btn-default' type='submit' onClick={this.onSubmit}>{owner.isNew ? 'Add Owner' : 'Update Owner'}</button>
            </div>
          </div>
        </form>
      </span>);
    };
    OwnerEditor.contextTypes = {
        router: React.PropTypes.object.isRequired
    };
    return OwnerEditor;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = OwnerEditor;
