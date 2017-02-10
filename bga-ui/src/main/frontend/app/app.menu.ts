export const APP_MENU: AppMenuItem[] = [

  {
    name: 'Home',
    description: 'Home page',
    icon: 'public',
    link: ['']
  },
  {
    name: 'SignIn',
    description: 'Login page',
    icon: 'public',
    link: ['singIn']
  },
  {
    name: 'SignUP',
    description: 'Registration page',
    icon: 'public',
    link: ['singUp']
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
    link: ['shopping-list'],
  }
];

export interface AppMenuItem {
  name: string;
  description: string;
  icon: string;
  link: string[];
  roles?: string[];
}
