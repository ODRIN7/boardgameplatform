///<reference path="recipes/recipes.component.ts"/>
import {NgModule} from '@angular/core';
import { BGAMyAppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {BrowserModule} from '@angular/platform-browser';
import {RecipesComponent} from "./recipes";
import {HeaderComponent} from "./header";
import {RecipeItemComponent} from "./recipes/recipe-list/recipe-item.component";
import {RecipeDetailComponent} from "./recipes/recipe-detail/recipe-detail.component";
import {RecipeListComponent} from "./recipes/recipe-list/recipe-list.component";
import {ShoppingListComponent} from "./shopping-list/shopping-list.component";
import {ShoppingListAddComponent} from "./shopping-list/shopping-list-add.component";
import {DropdownDirective} from "./shared/dropdown.directive";
import {RecipeService} from "./recipes/recipe.service";
import {ShoppingListService} from "./shopping-list/shopping-list.service";
import {routing} from "./app.routing";
import {RecipeStartComponent} from "./recipes/recipe-start/recipe-start.component";
import {RecipeEditComponent} from "./recipes/recipe-edit/recipe-edit.component";


@NgModule({
  declarations: [
    BGAMyAppComponent,
    HeaderComponent,
    RecipesComponent,
    ShoppingListAddComponent,
    ShoppingListComponent,
    RecipeListComponent,
    RecipeDetailComponent,
    RecipeItemComponent,
    DropdownDirective,
    RecipeStartComponent,
    RecipeEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    routing
  ],
  providers: [
    RecipeService,
    ShoppingListService
  ],
  bootstrap: [BGAMyAppComponent]
})
export class AppModule {

}
