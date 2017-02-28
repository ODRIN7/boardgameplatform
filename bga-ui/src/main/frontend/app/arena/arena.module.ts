import {NgModule} from '@angular/core';
import {COMMON_CHILD_MODULES} from "../shared/common/common.modules";
import {ARENA_MODULE} from "./arena.routing";
import {ArenaItemComponent} from "./item/arena-item.component";
import {ArenaComponent} from "./arena.component";
import {ArenaStartComponent} from "./starter/arena.start.component";
import {ArenaElementComponent} from "./element/arena-element.component";
import {GameComponent} from "./element/game/bga-game-element.component";
import {ChatComponent} from "./element/chat/chat.component";
import {RecentGamesComponent} from "../shared/components/recentgames/recentGames.component";


@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    ARENA_MODULE
  ],
  declarations: [
    ArenaComponent,
    ArenaItemComponent,
    ArenaStartComponent,
    ArenaElementComponent,
    GameComponent,
    ChatComponent

  ]
})
export class ArenaModule {
}
