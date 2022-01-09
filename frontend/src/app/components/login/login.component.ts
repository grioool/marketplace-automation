import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  private uri = 'http://localhost:8080';
  private registrationPath = 'registration';
  private mainPath = 'main';
  public loginForm: FormGroup;

  constructor(private http: HttpClient, private router: Router, private fb: FormBuilder) {
    this.createForm();
  }

  private createForm() {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    })
  }

  public get username() {
    return this.loginForm.get('username');
  }

  public get password() {
    return this.loginForm.get('password');
  }

  public OnLogin() {
    this.login(this.loginForm.get("username").value, this.loginForm.get("password").value);
  }

  public OnRegister() {
    this.router.navigate([this.registrationPath]).then();
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
}

