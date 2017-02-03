"use strict";
exports.NotEmpty = {
    message: 'Enter at least one character',
    validate: function (value) {
        return !!value && value.length > 0;
    }
};
exports.Digits = function (digits) {
    var reg = new RegExp('^\\d{1,' + digits + '}$');
    return {
        message: 'Must be a number with at most ' + digits + ' digits',
        validate: function (value) {
            return !!value && value.match(reg) !== null;
        }
    };
};
