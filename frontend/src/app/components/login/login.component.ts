import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {MainComponent} from "../main/main.component";
import {RegistrationComponent} from "../registration/registration.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = '';
  password = '';
  uri = 'http://localhost:8080';
  path = 'registration';
  mainPath = 'main';

  constructor(private http: HttpClient, private router: Router) {
  }

  public OnLogin() {
    this.login(this.username, this.password);
  }

  public OnRegister() {
    this.router.navigate([this.path]).then();
  }

  public login(username: string, password: string) {
    this.http.post(this.uri + '/login', {username: username, password: password})
      .subscribe((resp: any) => {

        this.router.navigate([this.mainPath]).then();
        localStorage.setItem('auth_token', resp.token);
      })
  }

  public logout() {
    localStorage.removeItem('token');
  }

  public get logIn(): boolean {
    return (localStorage.getItem('token') !== null);
  }

  ngOnInit() { }
}

