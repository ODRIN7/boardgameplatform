import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core/src/metadata/ng_module';
import {StatisticComponent} from "./statistic.component";

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: StatisticComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class STATISTIC_MODULE {
}



