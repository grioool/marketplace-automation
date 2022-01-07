import { Component, OnInit } from '@angular/core';
import {MainComponent} from "../main/main.component";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {LoginComponent} from "../login/login.component";

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
  nameC = '';
  wbKey = '';
  ozonKey = '';
  uri = 'http://localhost:8080';

  constructor(private http: HttpClient, private router: Router) {
  }

  OnLogin() {
    this.router.navigate([{routes: LoginComponent}]);
  }

  OnRegister() {
    this.register(this.username, this.email, this.password, this.nameC, this.wbKey, this.ozonKey);
  }

  register(username: string, email: string, password: string, nameC: string, wbKey: string, ozonKey: string) {
    this.http.post(this.uri + '/login', {username: username, email: email, password: password, nameC: nameC, wbKey: wbKey, ozonKey: ozonKey})
      .subscribe((resp: any) => {

        this.router.navigate([{routes: MainComponent}]);
        localStorage.setItem('auth_token', resp.token);
      })
  }

  ngOnInit(): void {
  }
}
