import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core/src/metadata/ng_module';


export const routes: Routes = [
  {
    path: 'users',
    pathMatch: 'prefix',
    loadChildren: 'app/admin-tables/user/user.module#UserModule'
  },
  {
    path: 'posts',
    pathMatch: 'prefix',
    loadChildren: 'app/admin-tables/post/post.module#PostModule'
  },
  {
    path: 'boardgames',
    pathMatch: 'prefix',
    loadChildren: 'app/admin-tables/boardgame/boardgame.module#BoardGameModule'
  },
  {
    path: 'games',
    pathMatch: 'prefix',
    loadChildren: 'app/admin-tables/game/game.module#GameModule'
  },
  {
    path: 'statistics',
    pathMatch: 'prefix',
    loadChildren: 'app/admin-tables/statistic/statistic.module#StatisticModule'
  },
  {
    path: 'notifications',
    pathMatch: 'prefix',
    loadChildren: 'app/admin-tables/notification/notification.module#NotificationModule'
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class ADMIN_ROUTING_MODULE {
}



