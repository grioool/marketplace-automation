import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {accessTokenKey} from "../components/login/login.component";

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

  public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(req.url === "http://localhost:8080" + "/login" || req.url === "http://localhost:8080" + "/token/refresh") return next.handle(req);
    const authReq = req.clone({
      headers: req.headers.set("Authorization", "Bearer " + localStorage.getItem(accessTokenKey)),
    });
    return next.handle(authReq);
  }
}
