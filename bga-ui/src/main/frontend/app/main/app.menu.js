"use strict";
var roles_1 = require("../shared/domain/roles");
exports.MAIN_MENU = [
    {
        title: 'Feeds',
        icon: 'dashboard',
        link: ['']
    },
    {
        title: 'Store',
        icon: 'receipt',
        link: ['/store']
    },
    {
        title: 'Arena',
        icon: 'view_quilt',
        link: ['/store']
    },
    {
        title: 'Manage Users',
        icon: 'people',
        link: ['/store'],
        roles: [roles_1.Role.ADMIN_ROLE]
    },
    {
        title: 'Manage BoardGames',
        icon: 'people',
        link: ['/store'],
        roles: [roles_1.Role.ADMIN_ROLE]
    },
    {
        title: 'Statistics',
        icon: 'people',
        link: ['/store'],
        roles: [roles_1.Role.ADMIN_ROLE]
    }
];
