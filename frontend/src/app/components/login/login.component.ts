import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

declare type AuthenticationResponse = {accessToken: string; refreshToken: string};

const refreshTokenKey: string = "refresh_token";
const accessTokenKey: string = "access_token";

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
    const params: HttpParams = new HttpParams()
      .set('username', username)
      .set('password', password);
    this.http.post<AuthenticationResponse>(this.uri + '/login', {}, {params})
      .subscribe((resp: AuthenticationResponse) => {

        this.router.navigate([this.mainPath]).then();
        localStorage.setItem('access_token', resp.accessToken);
        localStorage.setItem('refresh_token', resp.refreshToken);
      })
  }

  public logout() {
    localStorage.removeItem(accessTokenKey);
    localStorage.removeItem(refreshTokenKey);
  }
}

