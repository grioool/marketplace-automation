import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {NavigationPath} from "../classes/navigation-path";
import {environment} from "../../environments/environment";
import {Router} from "@angular/router";
import {Observable, of} from "rxjs";
import {JwtHelperService} from "@auth0/angular-jwt";
import {isPresent} from "../../util";

declare type AuthenticationResponse = { accessToken: string; refreshToken: string };

export const refreshTokenKey: string = "refresh_token";
export const accessTokenKey: string = "access_token";

@Injectable({
    providedIn: 'root',
})
export class AuthService {

    private uri: string = environment.apiHost;

    constructor(private http: HttpClient,
                private router: Router,
                private jwtHelper: JwtHelperService) {
    }

    public register(username: string, email: string, password: string, nameCompany: string, wbKey: string, ozonKey: string) {
        this.http.post(this.uri + '/registration', {
            username: username,
            password: password,
            email: email,
            nameCompany: nameCompany,
            wbKey: wbKey,
            ozonKey: ozonKey
        }).subscribe((resp: any) => {
            this.router.navigate([NavigationPath.LOGIN]).then();
        });
    }

    public login(username: string, password: string) {
        const params: HttpParams = new HttpParams()
            .set('username', username)
            .set('password', password);
        this.http.post<AuthenticationResponse>(this.uri + '/login', {}, {params})
            .subscribe((resp: AuthenticationResponse) => {
                this.router.navigate([NavigationPath.MAIN]).then();
                localStorage.setItem(accessTokenKey, resp.accessToken);
                localStorage.setItem(refreshTokenKey, resp.refreshToken);
            })
    }

    public logout() {
        localStorage.removeItem(accessTokenKey);
        localStorage.removeItem(refreshTokenKey);
        this.router.navigate([NavigationPath.LOGIN]).then();
    }

    public isAuthenticated(): Observable<boolean> {
        const token: string = localStorage.getItem(accessTokenKey);
        return of(isPresent(token) && !this.jwtHelper.isTokenExpired(token));
    }

}
