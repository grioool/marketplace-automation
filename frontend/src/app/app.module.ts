import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {UserList} from './components/user-list/user-list.component';
import {PurchaseList} from "./components/purchase-list/purchase-list.component";
import {RouterModule} from "@angular/router";
import {AppComponent} from "./components/app.component";
import {AppRoutingModule} from './app-routing.module';
import {ReportList} from "./components/report-list/report-list.component";
import {SupplyList} from "./components/supply-list/supply-list.component";
import {HeaderComponent} from './components/header/header.component';
import {LoginComponent} from './components/login/login.component';
import {RegistrationComponent} from './components/registration/registration.component';
import {ProfileComponent} from './components/profile/profile.component';
import {MainComponent} from './components/main/main.component';
import {InformationComponent} from './components/information/information.component';
import {AuthenticationInterceptor} from "./http-interceptor/authentication-interceptor";
import {SaleComponent} from './components/sale-list/sale.component';
import {OrderComponent} from './components/order-list/order.component';
import {JwtModule} from "@auth0/angular-jwt";
import {accessTokenKey} from "./services/auth.service";

@NgModule({
    declarations: [
        AppComponent, PurchaseList, UserList, ReportList, SupplyList, HeaderComponent, LoginComponent, RegistrationComponent, ProfileComponent, MainComponent, InformationComponent, SaleComponent, OrderComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        RouterModule,
        AppRoutingModule,
        ReactiveFormsModule,
        JwtModule.forRoot({
            config: {
                tokenGetter: () => localStorage.getItem(accessTokenKey)
            }
        })
    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthenticationInterceptor,
            multi: true,
        },
    ],
    bootstrap: [AppComponent]
})

export class AppModule {
}
