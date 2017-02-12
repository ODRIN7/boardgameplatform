import {NgModule} from '@angular/core';
import {COMMON_CHILD_MODULES} from "../../shared/common/common.modules";
import {BOARDGAME_MODUL} from "./boardgame-routing.module";
import {BoardGameComponent} from "./boardgame.component";


@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    BOARDGAME_MODUL
  ],
  declarations: [BoardGameComponent]
})
export class BoardGameModule {
}
