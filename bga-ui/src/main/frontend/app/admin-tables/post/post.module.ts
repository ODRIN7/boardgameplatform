import {NgModule} from '@angular/core';
import {COMMON_CHILD_MODULES} from "../../shared/common/common.modules";
import {POST_MODULE} from "./post-routing.module";
import {PostComponent} from "./post.component";

@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    POST_MODULE
  ],
  declarations: [PostComponent]
})
export class PostModule {
}
