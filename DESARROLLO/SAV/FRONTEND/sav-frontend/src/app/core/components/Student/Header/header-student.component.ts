import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../../services/auth.service";

@Component({
  selector: 'app-header-student',
  templateUrl: './header-student.component.html',
  styleUrls: ['./header-student.component.scss']
})
export class HeaderStudentComponent implements OnInit {

  lastName:string = ''
  firstName:string = ''
  siglas:string = ''
  constructor(private authService: AuthService,) { }

  ngOnInit() {
    this.lastName = this.authService.getLastNameStudent()
    this.firstName = this.authService.getFirstNameStudent()
    this.siglas = this.authService.getSiglasStudent()
  }

}
