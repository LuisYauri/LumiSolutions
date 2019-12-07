import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header-student',
  templateUrl: './header-student.component.html',
  styleUrls: ['./header-student.component.scss']
})
export class HeaderStudentComponent implements OnInit {

  lastName: string = ''
  firstName: string = ''
  siglas: string = ''

  visible = false;

  data = [
    {
      title: 'Grado',
      description: ''
    },
    {
      title: 'Sección',
      description: ''
    },
    {
      title: 'Año',
      description: ''
    },
  ];

  constructor(private authService: AuthService,private router: Router,) {
  }

  ngOnInit() {
    this.data[0].description = `${this.authService.getCodigoGradoStudent().toString()} Secundaria`
    this.data[1].description = this.authService.getSeccionStudent().toString()
    this.data[2].description = this.authService.getAnioStudent().toString()
    this.lastName = this.authService.getLastNameStudent()
    this.firstName = this.authService.getFirstNameStudent()
    this.siglas = this.authService.getSiglasStudent()
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
