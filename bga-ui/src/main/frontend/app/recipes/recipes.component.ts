import { Component } from '@angular/core';
import {Recipe} from "./recipe";

@Component({
    selector: 'bga-recipes',
    templateUrl: 'recipes.component.html'
})
export class RecipesComponent  {
  selectedRecipe: Recipe;

    constructor() { }
}
