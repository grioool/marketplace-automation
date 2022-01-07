import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {MainComponent} from "../main/main.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email = '';
  password = '';
  uri = 'http://localhost:8080';

  constructor(private http: HttpClient, private router: Router) {
  }

  OnLogin() {
    this.login(this.email, this.password);
  }

  login(email: string, password: string) {
    this.http.post(this.uri + '/login', {email: email, password: password})
      .subscribe((resp: any) => {

        this.router.navigate([{routes: MainComponent}]);
        localStorage.setItem('auth_token', resp.token);
      })
  }

  logout() {
    localStorage.removeItem('token');
  }

  public get logIn(): boolean {
    return (localStorage.getItem('token') !== null);
  }

  ngOnInit() { }
}

