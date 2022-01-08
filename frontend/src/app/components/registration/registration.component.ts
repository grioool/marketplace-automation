import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  username = '';
  email = '';
  password = '';
  passwordRep = '';
  nameCompany = '';
  wbKey = '';
  ozonKey = '';
  uri = 'http://localhost:8080';
  loginPath = 'login';

  constructor(private http: HttpClient, private router: Router) {
  }

  public OnLogin() {
    this.router.navigate([this.loginPath]).then();
  }

  public OnRegister() {
    this.register(this.username, this.email, this.password, this.nameCompany, this.wbKey, this.ozonKey);
  }

  public register(username: string, email: string, password: string, nameCompany: string, wbKey: string, ozonKey: string) {
    this.http.post(this.uri + '/registration', {username: username, password: password, email: email,  nameCompany: nameCompany, wbKey: wbKey, ozonKey: ozonKey})
      .subscribe((resp: any) => {

        this.router.navigate([this.loginPath]).then();
        localStorage.setItem('auth_token', resp.token);
      })
  }

  ngOnInit(): void {
  }
}
