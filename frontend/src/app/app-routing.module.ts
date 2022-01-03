import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PurchaseList } from "./components/purchase-list/purchase-list.component";
import { UserList } from "./components/user-list/user-list.component";
import {SupplyList} from "./components/supply-list/supply-list.component";
import {ReportList} from "./components/report-list/report-list.component";


const routes: Routes = [
  {path: "users", component: UserList},
  {path: "purchases", component: PurchaseList},
  {path: "supplies", component: SupplyList},
  {path: "reports", component: ReportList},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
