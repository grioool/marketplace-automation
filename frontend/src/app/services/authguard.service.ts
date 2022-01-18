import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {map, Observable, tap} from "rxjs";
import {AuthService} from "./auth.service";
import {NavigationPath} from "../classes/navigation-path";

@Injectable({
    providedIn: 'root',
})

export class AuthGuardService implements CanActivate {

    constructor(private _router: Router, private authService: AuthService) {
    }

    public canActivate(route: ActivatedRouteSnapshot,
                       state: RouterStateSnapshot): Observable<boolean> {
        return this.authService.isAuthenticated()
            .pipe(map(authenticated => {
                if (this.requireAuthentication(state.url)) {
                    if (authenticated) return true;
                    this._router.navigate([NavigationPath.LOGIN]).then();
                    return false;
                }
                if (authenticated) {
                    this._router.navigate([NavigationPath.MAIN]).then();
                    return false;
                }
                return true;
            }))
    }

    private requireAuthentication(url: string): boolean {
        return ![NavigationPath.REGISTRATION, NavigationPath.LOGIN].includes(url as never);
    }

}
