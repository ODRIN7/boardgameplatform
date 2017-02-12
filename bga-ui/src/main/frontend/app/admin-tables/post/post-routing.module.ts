import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core/src/metadata/ng_module';
import {PostComponent} from "./post.component";

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: PostComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class POST_MODULE {
}



