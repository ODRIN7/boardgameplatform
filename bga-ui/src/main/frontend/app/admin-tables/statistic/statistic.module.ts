import {NgModule} from '@angular/core';
import {COMMON_CHILD_MODULES} from "../../shared/common/common.modules";
import {STATISTIC_MODULE} from "./statistic-routing.module";
import {StatisticComponent} from "./statistic.component";


@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    STATISTIC_MODULE
  ],
  declarations: [StatisticComponent]
})
export class StatisticModule {
}
