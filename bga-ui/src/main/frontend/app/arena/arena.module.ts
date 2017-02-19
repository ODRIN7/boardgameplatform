import {NgModule} from '@angular/core';
import {COMMON_CHILD_MODULES} from "../shared/common/common.modules";
import {ARENA_MODULE} from "./arena.routing";
import {ArenaItemComponent} from "./arena-item.component";
import {ArenaComponent} from "./arena.component";
import {ArenaStartComponent} from "./arena.start.component";


@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    ARENA_MODULE
  ],
  declarations: [
    ArenaComponent,
    ArenaItemComponent,
    ArenaStartComponent]
})
export class ArenaModule {
}
