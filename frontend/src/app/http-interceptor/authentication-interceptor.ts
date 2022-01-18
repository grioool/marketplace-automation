import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {accessTokenKey} from "../services/auth.service";

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

    public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (req.url === environment.apiHost + "/login" || req.url === environment.apiHost + "/token/refresh") return next.handle(req);
        const authReq = req.clone({
            headers: req.headers.set("Authorization", "Bearer " + localStorage.getItem(accessTokenKey)),
        });
        return next.handle(authReq);
    }

}
