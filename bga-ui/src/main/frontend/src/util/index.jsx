"use strict";
var BACKEND_URL = (typeof __API_SERVER_URL__ === 'undefined' ? 'http://localhost:8080' : __API_SERVER_URL__);
exports.url = function (path) { return (BACKEND_URL + "/" + path); };
/**
 * path: relative PATH without host and port (i.e. '/api/123')
 * data: object that will be passed as request body
 * onSuccess: callback handler if request succeeded. Succeeded means it could technically be handled (i.e. valid json is returned)
 * regardless of the HTTP status code.
 */
exports.submitForm = function (method, path, data, onSuccess) {
    var requestUrl = exports.url(path);
    var fetchParams = {
        method: method,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };
    console.log('Submitting to ' + method + ' ' + requestUrl);
    return fetch(requestUrl, fetchParams)
        .then(function (response) { return response.status === 204 ? onSuccess(response.status, {}) : response.json().then(function (result) { return onSuccess(response.status, result); }); });
};
