import {Routes, RouterModule} from "@angular/router";
import {LoginComponent} from "./signIn/login.component";
import {SignUpComponent} from "./signUp/signUp.component";
import {MainComponent} from "./main/main.component";
import {UsersFormComponent} from "./users/+form/form.component";
import {UsersComponent} from "./users/users.component";
import {ArenaComponent} from "./arena/arena.component";
import {StoreComponent} from "./store/store.component";
import {DashboardComponent} from "./dashboard/dashboard.component";

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
    component: MainComponent,
    children: [
      {
        component: DashboardComponent,
        path: '',
      },
      {
        path: 'store',
        component: StoreComponent,
      },
      {
        path: 'arena',
        component: ArenaComponent,
      },
      {path: 'users', children: [
        {path: '', component: UsersComponent},
        {path: 'add', component: UsersFormComponent},
        {path: ':id/delete', component: UsersFormComponent},
        {path: ':id/edit', component: UsersFormComponent},
      ]},
    ]
  }

];
export const appRoutingProviders: any[] = [];

export const appRoutes: any = RouterModule.forRoot(routes, {useHash: true});
