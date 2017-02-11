import {Routes, RouterModule} from '@angular/router';
import {UserComponent} from './user.component';
import {NgModule} from '@angular/core/src/metadata/ng_module';


export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: UserComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class USER_MODULE {
}



