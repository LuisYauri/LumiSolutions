import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {NzNotificationService} from "ng-zorro-antd";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup
  varLoading: boolean = false

  constructor(private router: Router, private fb: FormBuilder, private authService: AuthService, private notificationService: NzNotificationService) {
  }

  ngOnInit() {
    this.getLoginForm()
  }

  private getLoginForm() {
    this.loginForm = this.fb.group({
      type: ['', [Validators.required]],
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    })
  }

  send() {
    if (!this.loginForm.valid) {
      for (const i in this.loginForm.controls) {
        this.loginForm.controls[i].markAsDirty()
        this.loginForm.controls[i].updateValueAndValidity()
      }
      console.log(this.loginForm.valid)
      return
    } else {
      this.sendCredentials()
    }
  }

  async sendCredentials() {
    this.varLoading = true
    try {
      const response = await this.authService.postLogin(this.gJsonLogin()).toPromise()
      localStorage.setItem('access_token', response['token']);
      this.varLoading = false
      await this.router.navigate(['/student/homework'])
    } catch (e) {
      console.log(e)
      this.varLoading = false
      this.notificationService.info('Datos Incorrectos', 'Su datos ingresados son incorrectos.')
    }
  }

  private gJsonLogin() {
    return {
      tipo: this.loginForm.controls['type'].value,
      usuario: this.loginForm.controls['username'].value,
      contrasenia: this.loginForm.controls['password'].value
    }
  }
}
