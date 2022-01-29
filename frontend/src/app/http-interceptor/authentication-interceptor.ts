import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {environment} from "../../environments/environment";
import {accessTokenKey} from "../services/auth.service";
import {NavigationPath} from "../classes/navigation-path";
import {Router} from "@angular/router";

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

    constructor(private router: Router) {
    }

    public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (req.url === environment.apiHost + NavigationPath.LOGIN || req.url === environment.apiHost + "/token/refresh" || req.url === environment.apiHost + NavigationPath.REGISTRATION) return next.handle(req);
        const authReq = req.clone({
            headers: req.headers.set("Authorization", "Bearer " + localStorage.getItem(accessTokenKey)),
        });
        return next.handle(authReq)
            .pipe(catchError((error: any) => {
                if(error.status === 403) this.router.navigate([NavigationPath.LOGIN]).then();
                return throwError(error);
            }));
    }
}
