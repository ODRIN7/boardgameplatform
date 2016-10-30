///<reference path="recipes/recipes.component.ts"/>
import {NgModule} from '@angular/core';
import { BGAMyAppComponent} from './app.component';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {BrowserModule} from '@angular/platform-browser';
import {RecipesComponent} from "./recipes";
import {HeaderComponent} from "./header";
import {RecipeItemComponent} from "./recipes/recipe-list/recipe-item.component";
import {RecipeDetailComponent} from "./recipes/recipe-detail/recipe-detail.component";
import {RecipeListComponent} from "./recipes/recipe-list/recipe-list.component";
import {ShoppingListComponent} from "./shopping-list/shopping-list.component";
import {ShoppingListAddComponent} from "./shopping-list/shopping-list-add.component";


@NgModule({
  declarations: [
    BGAMyAppComponent,
    HeaderComponent,
    RecipesComponent,
    ShoppingListAddComponent,
    ShoppingListComponent,
    RecipesComponent,
    RecipeListComponent,
    RecipeDetailComponent,
    RecipeItemComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [
  ],
  bootstrap: [BGAMyAppComponent]
})
export class AppModule {

}
