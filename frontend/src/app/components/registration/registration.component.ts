import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {NavigationPath} from "../../classes/navigation-path";
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {MessageService} from "primeng/api";

@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

    public registrationForm: FormGroup;

    constructor(private http: HttpClient,
                private authService: AuthService,
                private messageService: MessageService,
                private router: Router,
                private fb: FormBuilder) {
        this.createForm();
        this.messageService.add({severity:"error", summary: "dfds;lfds"})
    }

    private createForm() {
        this.registrationForm = this.fb.group({
            username: ['', [
                Validators.required,
                Validators.pattern(/^[(\w)-]{3,20}/)
            ]],
            email: ['', [
                Validators.required,
                Validators.email,
            ]],
            nameCompany: ['', [
                Validators.required,
                Validators.pattern(/^[A-Za-zА-Яа-яЁё]{2,20}/)
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
                    Validators.pattern(/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,10}/)
                ],
            ],
        })
    }

    public OnLogin() {
        this.router.navigate([NavigationPath.LOGIN]).then();
    }

    public OnRegister() {
        this.registrationForm.markAllAsTouched();
        if (this.registrationForm.valid)
            this.authService.register(
                this.registrationForm.get("username").value,
                this.registrationForm.get("email").value,
                this.registrationForm.get("password").value,
                this.registrationForm.get("nameCompany").value,
                this.registrationForm.get("wbKey").value
            );

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

    public get passwordRep() {
        return this.registrationForm.get('passwordRep');
    }

    public get password() {
        return this.registrationForm.get('password');
    }

    ngOnInit(): void {
    }

}
