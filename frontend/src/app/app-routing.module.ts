import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PurchaseList } from "./components/purchase-list/purchase-list.component";
import { UserList } from "./components/user-list/user-list.component";
import {SupplyList} from "./components/supply-list/supply-list.component";


const routes: Routes = [
  {path: "users", component: UserList},
  {path: "purchases", component: PurchaseList},
  {path: "supplies", component: SupplyList},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
