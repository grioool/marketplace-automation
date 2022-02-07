import { Component, OnInit } from '@angular/core';
import {PasswordService} from "../../services/password.service";

@Component({
  selector: 'app-reset-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

    public email: string;

  constructor(private passwordService: PasswordService) { }

  ngOnInit(): void {
  }

  public resetPassword(email: string) {
      this.passwordService.resetPassword(email);
  }

}
