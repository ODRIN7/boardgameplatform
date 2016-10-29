import {Routes, RouterModule} from '@angular/router';
import {GameStoreModule} from './about.component';
import {NgModule} from '@angular/core/src/metadata/ng_module';


export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: GameStoreModule
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class GameStoreRoutingModule {
}

