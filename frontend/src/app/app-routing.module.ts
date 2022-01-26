import {Component, NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PurchaseList} from "./components/purchase-list/purchase-list.component";
import {UserList} from "./components/user-list/user-list.component";
import {SupplyList} from "./components/supply-list/supply-list.component";
import {ReportList} from "./components/report-list/report-list.component";
import {HeaderComponent} from "./components/header/header.component";
import {MainComponent} from "./components/main/main.component";
import {RegistrationComponent} from "./components/registration/registration.component";
import {LoginComponent} from "./components/login/login.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {InformationComponent} from "./components/information/information.component";
import {AuthGuardService} from "./services/authguard.service";
import {SaleListComponent} from "./components/sale-list/sale-list.component";
import {OrderListComponent} from "./components/order-list/order-list.component";
import {MessagesComponent} from "./components/messages/messages.component";

const routes: Routes = [{
    path: '', canActivate: [AuthGuardService], children: [
        {path: "users", component: UserList},
        {path: "purchases", component: PurchaseList},
        {path: "supplies", component: SupplyList},
        {path: "reports", component: ReportList},
        {path: "header", component: HeaderComponent},
        {path: "main", component: MainComponent},
        {path: "registration", component: RegistrationComponent},
        {path: "login", component: LoginComponent},
        {path: "profile", component: ProfileComponent},
        {path: "information", component: InformationComponent},
        {path: "sales", component: SaleListComponent},
        {path: "orders", component: OrderListComponent},
        {path: "messages", component: MessagesComponent},
        {path: "**", redirectTo: "main"},
    ]
}];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
