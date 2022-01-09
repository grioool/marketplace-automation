import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  private uri = 'http://localhost:8080';
  private loginPath = 'login';

  public registrationForm: FormGroup;

  constructor(private http: HttpClient, private router: Router, private fb: FormBuilder) {
    this.createForm();
  }

  private createForm() {
    this.registrationForm = this.fb.group({
      username: ['', [
        Validators.required,
        Validators.pattern(/^[(\w)-]{4,20}/)
      ]],
      email: ['', [
        Validators.required,
        Validators.pattern(/^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+/)
      ]],
      nameCompany: ['', [
        Validators.required,
        Validators.pattern(/^[A-Za-zА-Яа-яЁё]{2,20}/)
      ]],
      ozonKey: ['', [
        Validators.required,
        Validators.pattern(/^[0-9]{2,20}/)
      ]],
      wbKey: ['', [
        Validators.required,
        Validators.pattern(/^[0-9]{2,20}/)
      ]],
      passwordRep: ['', [
        Validators.required
      ]],
      password: [
        '',
        [
          Validators.required,
          Validators.pattern(/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/)
        ],
      ],
    })
  }

  public OnLogin() {
    this.router.navigate([this.loginPath]).then();
  }

  public OnRegister() {
    this.register(this.registrationForm.get("username").value, this.registrationForm.get("email").value, this.registrationForm.get("password").value, this.registrationForm.get("nameCompany").value, this.registrationForm.get("wbKey").value, this.registrationForm.get("ozonKey").value);
  }

  public register(username: string, email: string, password: string, nameCompany: string, wbKey: string, ozonKey: string) {
    this.http.post(this.uri + '/registration', {username: username, password: password, email: email,  nameCompany: nameCompany, wbKey: wbKey, ozonKey: ozonKey})
      .subscribe((resp: any) => {

        this.router.navigate([this.loginPath]).then();
      })
  }

  public get username() {
    return this.registrationForm.get('username');
  }

  public get email() {
    return this.registrationForm.get('email');
  }

  public get nameCompany() {
    return this.registrationForm.get('nameCompany');
  }

  public get wbKey() {
    return this.registrationForm.get('wbKey');
  }

  public get ozonKey() {
    return this.registrationForm.get('ozonKey');
  }

  public get passwordRep() {
    return this.registrationForm.get('passwordRep');
  }

  public get password() {
    return this.registrationForm.get('password');
  }

  ngOnInit(): void {
  }
}
