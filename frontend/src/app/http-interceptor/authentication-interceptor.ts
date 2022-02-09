import {Injectable} from '@angular/core';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {environment} from "../../environments/environment";
import {accessTokenKey} from "../services/auth.service";
import {NavigationPath} from "../classes/navigation-path";
import {Router} from "@angular/router";
import {MessageService} from "primeng/api";
import {LocaleContextHolder} from "../classes/locale-context-holder";

export const ERROR_HEADER: string = "error";

@Injectable({
    providedIn: "root"
})
export class AuthenticationInterceptor implements HttpInterceptor {

    constructor(private router: Router,
                private messageService: MessageService) {
    }

    public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (![NavigationPath.LOGIN, "/token/refresh", NavigationPath.REGISTRATION, NavigationPath.PASSWORD]
            .includes(req.url.replace(environment.apiHost, ""))) {
            req = req.clone({
                headers: req.headers.set("Authorization", "Bearer " + localStorage.getItem(accessTokenKey)),
            });
        }

        req = req.clone({
            headers: req.headers.set("Accept-Language", LocaleContextHolder.getLocale().key),
        });

        return next.handle(req)
            .pipe(catchError((error: HttpErrorResponse) => {
                if (error.status === 403) this.router.navigate([NavigationPath.LOGIN]).then();
                this.messageService.add({
                    severity: "error",
                    summary: "Error",
                    detail: error.headers.get(ERROR_HEADER) || "Unknown error",
                    //detail:error.error,
                    key: "notification"
                })
                return throwError(() => error);
            }));
    }
}
