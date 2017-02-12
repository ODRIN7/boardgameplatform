import {NgModule} from '@angular/core';
import {COMMON_CHILD_MODULES} from "../../shared/common/common.modules";
import {NotificationComponent} from "./notification.component";
import {NOTIFICATION_MODUL} from "./notification-routing.module";


@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    NOTIFICATION_MODUL
  ],
  declarations: [NotificationComponent]
})
export class NotificationModule {
}
