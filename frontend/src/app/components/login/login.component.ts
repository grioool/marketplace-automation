import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

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
  loginForm: FormGroup;

  constructor(private http: HttpClient, private router: Router, private fb: FormBuilder) {
    this.createForm();
  }

  private createForm() {
    this.loginForm = this.fb.group({
      usernameForm: ['', [Validators.required]],
      passwordForm: [
        '',
        [
          Validators.required,
          Validators.pattern(/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/),
        ],
      ],
    })
  }

  get _username() {
    return this.loginForm.get('username');
  }

  get _password() {
    return this.loginForm.get('password');
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

