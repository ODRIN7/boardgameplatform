import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core/src/metadata/ng_module';
import {UsersComponent} from "./users.component";


export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: UsersComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class USERS_MODULE {
}



