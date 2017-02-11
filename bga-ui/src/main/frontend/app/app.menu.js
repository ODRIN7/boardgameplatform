"use strict";
var roles_1 = require("./shared/domain/roles");
exports.APP_MENU = [
    {
        name: 'Home',
        description: 'Home page',
        icon: 'public',
        link: ['']
    },
    {
        name: 'Playground',
        description: 'Playground page',
        icon: 'casino',
        link: ['playground']
    },
    {
        name: 'Recipes',
        description: 'Recipes page',
        icon: 'public',
        link: ['recipes'],
        roles: [roles_1.Role.ADMIN_ROLE]
    },
    {
        name: 'Shopping List',
        description: 'Shopping List',
        icon: 'public',
        link: ['shopping-list'],
        roles: [roles_1.Role.ADMIN_ROLE]
    }
];
