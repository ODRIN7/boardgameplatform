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
import {AuthService} from "./shared/auth/auth.services";
import {RequestInterceptor} from "./config/interceptors/request.interceptor";
import {BGAMyAppComponent} from "./app.component";
import {MainComponent} from "./main/main.component";

const httpInterceptorProviders: Type<any>[] = [
  RequestInterceptor,
];

@NgModule({
  declarations: [
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
    appRoutingProviders,
    httpInterceptorProviders,
    Title,
  ], // additional providers needed for this module
  entryComponents: [ ],
  bootstrap: [BGAMyAppComponent]
})
export class AppModule {

}
