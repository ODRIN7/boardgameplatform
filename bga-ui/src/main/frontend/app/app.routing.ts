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
    path: 'recipes',
    component: RecipesComponent,
    children: RECIPE_ROUTES
  },
  {
    path: 'shopping-list',
    component: ShoppingListComponent
  },
  {
    path: 'singIn',
    component: LoginComponent
  },
  {
    path: 'signUp',
    component: SignupComponent
  }

];

export const AppRoutingModule = RouterModule.forRoot(APP_ROUTES);
