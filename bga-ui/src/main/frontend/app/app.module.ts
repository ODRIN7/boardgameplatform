import {NgModule, Type} from "@angular/core";
import {LoginComponent} from "./signIn/login.component";
import {COMMON_ROOT_MODULES} from "./shared/common/common.modules";
import {NgxChartsModule} from "@swimlane/ngx-charts";
import {appRoutes, appRoutingProviders} from "./app.routing";
import {CovalentExpansionPanelModule, CovalentCoreModule} from "@covalent/core";
import {CovalentMarkdownModule} from "@covalent/markdown";
import {CovalentHighlightModule} from "@covalent/highlight";
import {CovalentHttpModule} from "@covalent/http";
import {CovalentChartsModule} from "@covalent/charts";
import {BrowserModule, Title} from "@angular/platform-browser";
import {AuthService} from "./shared/services/auth/auth.services";
import {RequestInterceptor} from "./config/interceptors/request.interceptor";
import {BGAMyAppComponent} from "./app.component";
import {MainComponent} from "./main/main.component";
import {FavouriteComponent} from "./dashboard/favourite/favourite.component";
import {GameBoardComponent} from "./dashboard/gameboard/gameboard.component";
import {RecentGamesComponent} from "./shared/components/recentgames/recentGames.component";
import {PageInformationComponent} from "./dashboard/pageinformation/pageinformation.component";
import {NewsComponent} from "./dashboard/news/news.component";
import {SignUpComponent} from "./signUp/signUp.component";
import {UsersFormComponent} from "./users/+form/form.component";
import {UsersComponent} from "./users/users.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {StoreService} from "./shared/services/store.service";
import {MessagesService} from "./shared/services/messages.service";

const httpInterceptorProviders: Type<any>[] = [
  RequestInterceptor,
];

@NgModule({
  declarations: [
    BGAMyAppComponent,
    DashboardComponent,
    UsersComponent,
    UsersFormComponent,
    LoginComponent,
    MainComponent,
    SignUpComponent,
    NewsComponent,
    PageInformationComponent,
    RecentGamesComponent,
    GameBoardComponent,
    FavouriteComponent,
    LoginComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    CovalentCoreModule.forRoot(),
    CovalentChartsModule.forRoot(),
    CovalentHttpModule.forRoot({
      interceptors: [{
        interceptor: RequestInterceptor, paths: ['**'],
      }],
    }),
    CovalentHighlightModule.forRoot(),
    CovalentMarkdownModule.forRoot(),
    CovalentExpansionPanelModule.forRoot(),
    appRoutes,
    NgxChartsModule,
    COMMON_ROOT_MODULES
  ],
  providers: [
    AuthService,
    StoreService,
    appRoutingProviders,
    httpInterceptorProviders,
    MessagesService,
    Title,
  ], // additional providers needed for this module
  entryComponents: [ ],
  bootstrap: [BGAMyAppComponent]
})
export class AppModule {

}
