import {NgModule} from "@angular/core";
import {COMMON_CHILD_MODULES} from "../shared/common/common.modules";
import {NewsComponent} from "./news/news.component";
import {PageInformationComponent} from "./pageinformation/pageinformation.component";
import {RecentGamesComponent} from "./recentgames/recentGames.component";
import {GameBoardComponent} from "./gameboard/gameboard.component";
import {FavouriteComponent} from "./favourite/favourite.component";
import {DASHBOARD} from "./dashboard.routing";
import {DashboardComponent} from "./dashboard.component";
import {OpenGameComponent} from "./gameboard/item/open-game-item.component";

@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,

    DASHBOARD
  ],
  declarations: [
    DashboardComponent,
    NewsComponent,
    PageInformationComponent,
    RecentGamesComponent,
    GameBoardComponent,
    FavouriteComponent,
    OpenGameComponent
  ],
  exports: [
    NewsComponent,
    PageInformationComponent,
    RecentGamesComponent,
    GameBoardComponent,
    OpenGameComponent,
    FavouriteComponent]
})
export class DashboardModule {
}
