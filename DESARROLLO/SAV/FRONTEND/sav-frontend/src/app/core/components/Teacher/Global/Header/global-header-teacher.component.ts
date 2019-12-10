import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-global-header-teacher',
  templateUrl: './global-header-teacher.component.html',
  styleUrls: ['./global-header-teacher.component.scss']
})
export class GlobalHeaderTeacherComponent implements OnInit {

  lastName: string = ''
  firstName: string = ''
  siglas: string = ''

  visible = false;

  constructor(private authService: AuthService, private router: Router,) {
  }

  ngOnInit() {
    this.lastName = this.authService.getDataUsername().apellidoPaterno
    this.firstName = this.authService.getDataUsername().nombres
    this.siglas = this.authService.getDataUsername().siglas
  }

  open() {
    this.visible = true
  }

  close() {
    this.visible = false
  }

  logout() {
    this.authService.logout()
    this.router.navigate(['/']);
    this.visible = false
  }

}
