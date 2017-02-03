"use strict";
var React = require('react');
var FieldFeedbackPanel_1 = require('./FieldFeedbackPanel');
var NoConstraint = {
    message: '',
    validate: function (v) { return true; }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var object = _a.object, error = _a.error, name = _a.name, _b = _a.constraint, constraint = _b === void 0 ? NoConstraint : _b, label = _a.label, onChange = _a.onChange;
    var handleOnChange = function (event) {
        var value = event.target.value;
        // run validation (if any)
        var error = null;
        var fieldError = constraint.validate(value) === false ? { field: name, message: constraint.message } : null;
        // invoke callback
        onChange(name, value, fieldError);
    };
    var value = object[name];
    var fieldError = error && error.fieldErrors[name];
    var valid = !fieldError && value !== null && value !== undefined;
    var cssGroup = "form-group " + (fieldError ? 'has-error' : '');
    return (<div className={cssGroup}>
      <label className='col-sm-2 control-label'>{label}</label>

      <div className='col-sm-10'>
        <input type='text' name={name} className='form-control' value={value} onChange={handleOnChange}/>

         <FieldFeedbackPanel_1.default valid={valid} fieldError={fieldError}/>
      </div>
    </div>);
};
