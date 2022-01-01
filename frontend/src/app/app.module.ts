import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserList } from './components/user-list/user-list.component';
import { PurchaseList } from "./components/purchase-list/purchase-list.component";
import { RouterModule } from "@angular/router";
import { AppComponent } from "./components/app.component";
import { AppRoutingModule } from './app-routing.module';
import {ReportList} from "./components/report-list/report-list.component";
import {SupplyList} from "./components/supply-list/supply-list.component";

@NgModule({
  declarations: [
    AppComponent, PurchaseList, UserList, ReportList, SupplyList
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, RouterModule, AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
