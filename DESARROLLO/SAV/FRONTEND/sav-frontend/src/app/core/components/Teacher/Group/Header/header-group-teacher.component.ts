import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header-group-teacher',
  templateUrl: './header-group-teacher.component.html',
  styleUrls: ['./header-group-teacher.component.scss']
})
export class HeaderGroupTeacherComponent implements OnInit {

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

  returnPanel() {
    localStorage.removeItem('data_aula');
    this.router.navigate(['/teacher-global/classroom'])
    this.visible = false
  }
}
