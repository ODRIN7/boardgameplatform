import {NgModule} from '@angular/core';
import {COMMON_CHILD_MODULES} from "../../shared/common/common.modules";
import {GAME_MODUL} from "./game-routing.module";
import {GameComponent} from "./game.component";


@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    GAME_MODUL
  ],
  declarations: [GameComponent]
})
export class GameModule {
}
