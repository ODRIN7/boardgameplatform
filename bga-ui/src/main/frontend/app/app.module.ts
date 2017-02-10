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
import {DropdownDirective} from "./header/dropdown.directive";
import {RecipeService} from "./recipes/recipe.service";
import {ShoppingListService} from "./shopping-list/shopping-list.service";
import {routing} from "./app.routing";
import {RecipeStartComponent} from "./recipes/recipe-start/recipe-start.component";
import {RecipeEditComponent} from "./recipes/recipe-edit/recipe-edit.component";
import {NotFoundComponent} from "./not-found/not-found.component";
import {HomeComponent} from "./home/home.component";
import {AuthServices} from "./shared/auth/auth.services";
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/sign.up.component";
import {
  MdInputModule,
  MdIconModule,
  MdSidenavModule,
  MdCardModule,
  MdButtonModule,
  MdCheckboxModule,
  MdCoreModule,
  MdGridListModule,
  MdListModule,
  MdMenuModule,
  MdProgressBarModule,
  MdProgressCircleModule,
  MdRadioModule,
  MdSlideToggleModule,
  MdSliderModule,
  MdTabsModule,
  MdToolbarModule,
  MdTooltipModule,
  MdButtonToggleModule,
  MdDialogModule,
  MdSelectModule,
  MdSnackBarModule
} from '@angular/material';

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
    RecipeEditComponent,
    NotFoundComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    routing,
    MdButtonModule,
    MdButtonToggleModule,
    MdCardModule,
    MdCheckboxModule,
    MdCoreModule,
    MdDialogModule,
    MdGridListModule,
    MdIconModule,
    MdInputModule,
    MdListModule,
    MdMenuModule,
    MdProgressBarModule,
    MdProgressCircleModule,
    MdRadioModule,
    MdSelectModule,
    MdSidenavModule,
    MdSlideToggleModule,
    MdSliderModule,
    MdSnackBarModule,
    MdTabsModule,
    MdToolbarModule
  ],
  providers: [
    RecipeService,
    ShoppingListService,
    AuthServices
  ],
  bootstrap: [BGAMyAppComponent]
})
export class AppModule {

}
