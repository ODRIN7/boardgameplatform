import {NgModule} from "@angular/core";
import {BGAMyAppComponent} from "./app.component";
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
import {AppRoutingModule} from "./app.routing";
import {RecipeStartComponent} from "./recipes/recipe-start/recipe-start.component";
import {RecipeEditComponent} from "./recipes/recipe-edit/recipe-edit.component";
import {NotFoundComponent} from "./not-found/not-found.component";
import {HomeComponent} from "./home/home.component";
import {AuthService} from "./shared/auth/auth.services";
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/sign.up.component";
import {COMMON_ROOT_MODULES} from "./shared";

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
    COMMON_ROOT_MODULES,
    AppRoutingModule,
  ],
  providers: [
    RecipeService,
    ShoppingListService,
    AuthService
  ],
  bootstrap: [BGAMyAppComponent]
})
export class AppModule {

}
