import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-students-global-teacher',
  templateUrl: './students-global-teacher.component.html',
  styleUrls: ['./students-global-teacher.component.scss']
})
export class StudentsGlobalTeacherComponent implements OnInit {

  varHeader = {
    title: 'Mis Estudiantes',
    icon: 'profile',
    url: ''
  }

  varTitle = 'Banco de estudiantes'
  varLoading = false
  constructor() { }

  ngOnInit() {
  }

}
