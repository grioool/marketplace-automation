import {Component} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {NavigationPath} from "../../classes/navigation-path";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(
      private authService: AuthService,
      private router: Router
  ) {
  }


    public OnLogout() {
        this.authService.logout();
    }

    public isMenuActive(): boolean {
        return ![NavigationPath.LOGIN, NavigationPath.REGISTRATION].includes(this.router.url as any)
    }
}
