import {NgModule} from '@angular/core';
import {UserComponent} from './user.component';
import {USER_MODULE} from './user-routing.module';
import {COMMON_CHILD_MODULES} from "../shared/common/common.modules";

@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    USER_MODULE
  ],
  declarations: [UserComponent]
})
export class UserModule {
}
