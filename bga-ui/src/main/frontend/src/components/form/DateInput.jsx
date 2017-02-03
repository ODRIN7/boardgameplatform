/// <reference path="../../react-datepicker.d.ts" />
"use strict";
var React = require('react');
var ReactDatePicker = require('react-datepicker');
var moment = require('moment');
var FieldFeedbackPanel_1 = require('./FieldFeedbackPanel');
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var object = _a.object, error = _a.error, name = _a.name, label = _a.label, onChange = _a.onChange;
    var handleOnChange = function (value) {
        var dateString = value ? value.format('YYYY/MM/DD') : null;
        onChange(name, dateString, null);
    };
    var selectedValue = object[name] ? moment(object[name], 'YYYY/MM/DD') : null;
    var fieldError = error && error.fieldErrors[name];
    var valid = !fieldError && selectedValue != null;
    var cssGroup = "form-group " + (fieldError ? 'has-error' : '');
    return (<div className={cssGroup}>
      <label className='col-sm-2 control-label'>{label}</label>

      <div className='col-sm-10'>
        <ReactDatePicker selected={selectedValue} onChange={handleOnChange} className='form-control' dateFormat='YYYY-MM-DD'/>
        <span className='glyphicon glyphicon-ok form-control-feedback' aria-hidden='true'></span>
        <FieldFeedbackPanel_1.default valid={valid} fieldError={fieldError}/>
      </div>
    </div>);
};
