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
    link: ['recipes'],
    roles: [Role.ADMIN_ROLE]
  },
  {
    name: 'Shopping List',
    description: 'Shopping List',
    icon: 'public',
    link: ['shopping-list'],
    roles: [Role.ADMIN_ROLE]
  },
  {
    name: 'Users',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/users']
  },
  {
    name: 'Posts',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/posts']
  },
  {
    name: 'BoardGames',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/boardgames']
  },
  {
    name: 'Games',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/games']
  },
  {
    name: 'Statistics',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/statistics']
  },
  {
    name: 'Notification',
    description: 'CRUD table',
    icon: 'public',
    link: ['admin/notifications']
  }
];

export interface AppMenuItem {
  name: string;
  description: string;
  icon: string;
  link: string[];
  roles?: Role[];
}
