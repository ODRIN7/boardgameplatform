import {Routes, RouterModule} from "@angular/router";
import {LoginComponent} from "./signIn/login.component";
import {SignUpComponent} from "./signUp/signUp.component";
import {MainComponent} from "./main/main.component";

const routes: Routes = [
  {
    path: 'signin',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignUpComponent
  },
  {
    path: '',
    component: LoginComponent,
    children: [
      {
        component: LoginComponent,
        path: '',
      },
      {
        path: 'store',
        component: LoginComponent,
      },
      {
        path: 'arena',
        component: MainComponent,
      },
      {path: 'users', children: [
        {path: '', component: LoginComponent},
        {path: 'add', component: LoginComponent},
        {path: ':id/delete', component: LoginComponent},
        {path: ':id/edit', component: LoginComponent},
      ]},
    ]
  }

];
export const appRoutingProviders: any[] = [];

export const appRoutes: any = RouterModule.forRoot(routes, {useHash: true});
