import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PurchaseList } from "./components/purchase-list/purchase-list";
import { UserList } from "./components/user-list/user-list";

const routes: Routes = [
  {path: "users", component: UserList},
  {path: "purchases", component: PurchaseList},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
