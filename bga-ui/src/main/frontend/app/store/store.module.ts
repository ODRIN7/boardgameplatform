import {NgModule} from '@angular/core';
import {StoreDetailComponent} from "./store-detail.component";
import {StoreComponent} from "./store.component";
import {STORE_MODULE} from "./store.routing";
import {COMMON_CHILD_MODULES} from "../shared/common/common.modules";
import {StoreItemComponent} from "./store-item.component";
import {StoreStartComponent} from "./StoreStartComponent";


@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    STORE_MODULE
  ],
  declarations: [
    StoreDetailComponent,
    StoreComponent,
    StoreItemComponent,
    StoreStartComponent]
})
export class StoreModule {
}
