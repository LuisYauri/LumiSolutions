import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {

  //Falta aún implementar los servicios para estudiante
  //Quitar eso cuando se implemente

  isCollapsed = false;

  constructor() { }

  ngOnInit() {
  }

}
