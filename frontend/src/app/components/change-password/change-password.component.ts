import {Component, OnInit} from '@angular/core';
import {PasswordService} from "../../services/password.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
    selector: 'app-change-password',
    templateUrl: './change-password.component.html',
    styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent {

    public passwordForm: FormGroup;

    constructor(private passwordService: PasswordService,
                private fb: FormBuilder) {
        this.createForm();
    }

    private createForm() {
        this.passwordForm = this.fb.group({
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

    public changePassword() {
        this.passwordForm.markAllAsTouched();
        if (this.passwordForm.valid || this.passwordForm.get('password').value !== this.passwordForm.get('passwordRep').value)
            this.passwordService.changePassword(this.passwordForm.get('password').value);
    }

    public get passwordRep() {
        return this.passwordForm.get('passwordRep');
    }

    public get password() {
        return this.passwordForm.get('password');
    }
}

