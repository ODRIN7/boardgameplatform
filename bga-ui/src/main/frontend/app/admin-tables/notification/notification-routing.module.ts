import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core/src/metadata/ng_module';
import {NotificationComponent} from "./notification.component";

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: NotificationComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class NOTIFICATION_MODUL {
}



