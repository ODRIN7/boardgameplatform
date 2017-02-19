import {Routes, RouterModule} from "@angular/router";
import {NgModule} from "@angular/core";
import {ArenaComponent} from "./arena.component";
import {ArenaStartComponent} from "./arena.start.component";


export const routes: Routes = [
  {
    path: '', component: ArenaComponent,
    children: [
      {path: '', component: ArenaStartComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class ARENA_MODULE {
}
