"use strict";
var React = require('react');
var FieldFeedbackPanel_1 = require('./FieldFeedbackPanel');
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var object = _a.object, error = _a.error, name = _a.name, label = _a.label, options = _a.options, onChange = _a.onChange;
    var handleOnChange = function (event) {
        console.log('select on change', event.target.value);
        onChange(name, event.target.value, null);
    };
    var selectedValue = object[name] || '';
    var fieldError = error && error.fieldErrors[name];
    var valid = !fieldError && selectedValue !== '';
    var cssGroup = "form-group " + (fieldError ? 'has-error' : '');
    return (<div className={cssGroup}>
      <label className='col-sm-2 control-label'>{label}</label>

      <div className='col-sm-10'>
        <select size={5} className='form-control' name={name} onChange={handleOnChange} value={selectedValue}>
          {options.map(function (option) { return <option key={option.value} value={option.value}>{option.name}</option>; })}
        </select>
        <FieldFeedbackPanel_1.default valid={valid} fieldError={fieldError}/>
      </div>
    </div>);
};
