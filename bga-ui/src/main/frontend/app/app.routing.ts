import {Routes, RouterModule} from "@angular/router";
import {RecipesComponent} from "./recipes/recipes.component";
import {ShoppingListComponent} from "./shopping-list/shopping-list.component";
import {RECIPE_ROUTES} from "./recipes/recipes.routes";
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/sign.up.component";

const APP_ROUTES: Routes = [
  {
    path: '',
    pathMatch: 'prefix',
    redirectTo: 'home'
  },
  {
    path: 'home',
    pathMatch: 'prefix',
    component: HomeComponent
  },
  {
    path: 'signIn',
    component: LoginComponent
  },
  {
    path: 'signUp',
    component: SignupComponent
  },
  {
    path: 'admin',
    pathMatch: 'prefix',
    loadChildren: 'app/admin-tables/admin-routing.module#ADMIN_ROUTING_MODULE'
  },
  {
    path: 'recipes',
    component: RecipesComponent,
    children: RECIPE_ROUTES
  },
  {
    path: 'shopping-list',
    component: ShoppingListComponent
  },
];

export const AppRoutingModule = RouterModule.forRoot(APP_ROUTES);
