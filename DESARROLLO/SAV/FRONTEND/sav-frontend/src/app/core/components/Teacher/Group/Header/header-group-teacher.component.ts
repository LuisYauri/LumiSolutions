import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../../../services/auth.service";
import {Router} from "@angular/router";
import {AulaDataToken} from "../../../../../model/auth.model";

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
  aula: AulaDataToken

  constructor(private authService: AuthService, private router: Router,) {
  }

  ngOnInit() {
    this.lastName = this.authService.getDataUsername().apellidoPaterno
    this.firstName = this.authService.getDataUsername().nombres
    this.siglas = this.authService.getDataUsername().siglas
    this.getDataAula()
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

  getDataAula() {
    this.aula = this.authService.getAula()
    console.log(this.aula)
  }
}
