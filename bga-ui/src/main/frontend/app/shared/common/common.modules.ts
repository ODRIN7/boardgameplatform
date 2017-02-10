import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {BrowserModule} from "@angular/platform-browser";
import {CommonModule} from "@angular/common";
import {
  MdInputModule,
  MdIconModule,
  MdSidenavModule,
  MdCardModule,
  MdButtonModule,
  MdCheckboxModule,
  MdCoreModule,
  MdGridListModule,
  MdListModule,
  MdMenuModule,
  MdProgressBarModule,
  MdProgressCircleModule,
  MdRadioModule,
  MdSlideToggleModule,
  MdSliderModule,
  MdTabsModule,
  MdToolbarModule,
  MdTooltipModule,
  MdButtonToggleModule,
  MdDialogModule,
  MdSelectModule,
  MdSnackBarModule
} from "@angular/material";


export const COMMON_ROOT_MODULES = [
  BrowserModule,
  FormsModule,
  HttpModule,
  CommonModule,
  ReactiveFormsModule,
  MdButtonModule.forRoot(),
  MdButtonToggleModule.forRoot(),
  MdCardModule.forRoot(),
  MdCheckboxModule.forRoot(),
  MdCoreModule.forRoot(),
  MdDialogModule.forRoot(),
  MdGridListModule.forRoot(),
  MdIconModule.forRoot(),
  MdInputModule.forRoot(),
  MdListModule.forRoot(),
  MdMenuModule.forRoot(),
  MdProgressBarModule.forRoot(),
  MdProgressCircleModule.forRoot(),
  MdRadioModule.forRoot(),
  MdSelectModule.forRoot(),
  MdSidenavModule.forRoot(),
  MdSlideToggleModule.forRoot(),
  MdSliderModule.forRoot(),
  MdSnackBarModule.forRoot(),
  MdTabsModule.forRoot(),
  MdToolbarModule.forRoot(),
  MdTooltipModule.forRoot()
];
