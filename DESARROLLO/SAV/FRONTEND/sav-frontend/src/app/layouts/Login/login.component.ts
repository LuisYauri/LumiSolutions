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
    //Al iniciar el componente se llenan los datos por defecto
    this.getLoginForm()
  }

  private getLoginForm() {
    //Esta función llena en el formulario datos por defecto para iniciar sesión mas rápido
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    })
  }

  send() {
    //Esta función se encarga de verificar si los datos ingresados en el formulario son válidos
    //Si lo son, se realiza una petición al Backend
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
      const response: any = await this.authService.postLogin(this.gJsonLogin()).toPromise()
      localStorage.setItem('access_token', response['token']);
      const username = this.authService.getUsername()
      localStorage.setItem('username', username);
      try {
        const response: any = await this.authService.getLoginData(username).toPromise()
        localStorage.setItem('data_username', JSON.stringify(response));
        this.varLoading = false
        this.authService.getDataUsername()
        await this.router.navigate(['/student/homework'])
      } catch (e) {
        console.log(e)
      }
    } catch (e) {
      console.log(e)
      this.varLoading = false
      this.notificationService.info('Datos Incorrectos', 'Su datos ingresados son incorrectos.')
    }
  }

  private gJsonLogin() {
    //Esta función retorna los datos introducidos en el formulario en formato JSON
    return {
      username: this.loginForm.controls['username'].value,
      password: this.loginForm.controls['password'].value
    }
  }
}
