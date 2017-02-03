"use strict";
var React = require('react');
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var valid = _a.valid, fieldError = _a.fieldError;
    if (valid) {
        return <span className='glyphicon glyphicon-ok form-control-feedback' aria-hidden='true'></span>;
    }
    if (fieldError) {
        return (<span>
        <span className='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span>
        <span className='help-inline'>{fieldError.message}</span>
      </span>);
    }
    return null;
};
