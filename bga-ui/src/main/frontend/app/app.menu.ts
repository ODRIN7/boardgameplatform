import {Role} from "./shared/domain/roles";
export const APP_MENU: AppMenuItem[] = [

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
    link: ['recipes']
  },
  {
    name: 'Shopping List',
    description: 'Shopping List',
    icon: 'public',
    link: ['shopping-list']
  },
  {
    name: 'Users',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/users'],
    roles: [Role.ADMIN_ROLE]
  },
  {
    name: 'Posts',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/posts'],
    roles: [Role.ADMIN_ROLE]
  },
  {
    name: 'BoardGames',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/boardgames'],
    roles: [Role.ADMIN_ROLE]
  },
  {
    name: 'Games',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/games'],
    roles: [Role.ADMIN_ROLE]
  },
  {
    name: 'Statistics',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/statistics'],
    roles: [Role.ADMIN_ROLE]
  },
  {
    name: 'Notification',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/notifications'],
    roles: [Role.ADMIN_ROLE]
  }
];

export interface AppMenuItem {
  name: string;
  description: string;
  icon: string;
  link: string[];
  roles?: Role[];
}
