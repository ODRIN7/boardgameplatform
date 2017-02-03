"use strict";
var util_1 = require('../../util');
var toSelectOptions = function (pettypes) { return pettypes.map(function (pettype) { return ({ value: pettype.id, name: pettype.name }); }); };
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (ownerId, petLoaderPromise) {
    return Promise.all([fetch(util_1.url('/api/pettypes'))
            .then(function (response) { return response.json(); })
            .then(toSelectOptions),
        fetch(util_1.url('/api/owner/' + ownerId))
            .then(function (response) { return response.json(); }),
        petLoaderPromise,
    ]).then(function (results) { return ({
        pettypes: results[0],
        owner: results[1],
        pet: results[2]
    }); });
};
