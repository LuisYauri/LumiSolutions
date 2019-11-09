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
      type: ['E', [Validators.required]],
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

  sendCredentials() {
    let ga = this
    this.varLoading = true
    setTimeout(function () {
      if( ga.loginForm.controls['username'].value === 'miguel.moya@unmsm.edu.pe' && ga.loginForm.controls['password'].value === '12345'){
        ga.router.navigate(['/student/homework'])
      }else{
        ga.varLoading = false
        ga.notificationService.create(
          'error',
          'Datos Incorrectos',
          'Revise sus datos.'
        );
      }
    }, 3000);
  }

  // async sendCredentials() {
  //   //Esta función usa el servicio postLogin para iniciar sesión con los datos obtenidos del formulario
  //   this.varLoading = true
  //   try {
  //     const response = await this.authService.postLogin(this.gJsonLogin()).toPromise()
  //     localStorage.setItem('access_token', response['token']);
  //     this.varLoading = false
  //     await this.router.navigate(['/student/homework'])
  //   } catch (e) {
  //     console.log(e)
  //     this.varLoading = false
  //     this.notificationService.info('Datos Incorrectos', 'Su datos ingresados son incorrectos.')
  //   }
  // }

  private gJsonLogin() {
    //Esta función retorna los datos introducidos en el formulario en formato JSON
    return {
      tipo: this.loginForm.controls['type'].value,
      usuario: this.loginForm.controls['username'].value,
      contrasenia: this.loginForm.controls['password'].value
    }
  }
}
