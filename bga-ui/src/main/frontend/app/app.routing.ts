import {Routes, RouterModule} from "@angular/router";
import {RecipesComponent} from "./recipes/recipes.component";
import {ShoppingListComponent} from "./shopping-list/shopping-list.component";
import {RECIPE_ROUTES} from "./recipes/recipes.routes";
import {HomeComponent} from "./home/home.component";

const APP_ROUTES: Routes = [
  {
    path: '',
    redirectTo: '/recipes',
    pathMatch: 'full'
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
    path: 'home',
    component: HomeComponent
  }

];

export const routing = RouterModule.forRoot(APP_ROUTES);
