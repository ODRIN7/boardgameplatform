import {Routes, RouterModule} from '@angular/router';
import {GameComponent} from './game.component';
import {NgModule} from '@angular/core/src/metadata/ng_module';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: GameComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class GAME_MODUL {
}



