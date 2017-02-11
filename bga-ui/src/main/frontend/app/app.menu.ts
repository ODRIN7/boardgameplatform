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
    description: 'user table',
    icon: 'public',
    link: ['users']
  }
];

export interface AppMenuItem {
  name: string;
  description: string;
  icon: string;
  link: string[];
  roles?: Role[];
}
