import {Routes, RouterModule} from '@angular/router';
import {BoardGameComponent} from './boardgame.component';
import {NgModule} from '@angular/core/src/metadata/ng_module';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: BoardGameComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class BOARDGAME_MODUL {
}



