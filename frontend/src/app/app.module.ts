import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserList } from './components/user-list/user-list';
import { PurchaseList } from "./components/purchase-list/purchase-list";
import { RouterModule } from "@angular/router";
import { AppComponent } from "./components/app.component";

@NgModule({
  declarations: [
    AppComponent, PurchaseList, UserList
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent, PurchaseList, UserList]
})

export class AppModule { }
