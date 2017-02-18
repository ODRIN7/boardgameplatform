import {NgModule} from '@angular/core';
import {UsersComponent} from "./users.component";
import {USERS_MODULE} from "./users-routing.module";

@NgModule({
  imports: [
    USERS_MODULE
  ],
  declarations: [UsersComponent]
})
export class UsersModule {
}
