import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-homework-student',
  templateUrl: './homework-student.component.html',
  styleUrls: ['./homework-student.component.scss']
})
export class HomeworkStudentComponent implements OnInit {

  varHeader = {
    title:'Tareas',
    icon:'file-text',
    url:''
  }

  varTitle = 'Lista de Tareas'

  homeworks = [
    {
      idTarea: '1',
      titulo: 'Tarea 1',
      cantidadPreguntas: '10',
      fechaLimite: '17-01-15',
      tiempoLimite: '10:00 horas',
      contenido: 'NroNaturales'
    },{
      idTarea: '2',
      titulo: 'Tarea 2',
      cantidadPreguntas: '10',
      fechaLimite: '17-01-15',
      tiempoLimite: '10:00 horas',
      contenido: 'NroNaturales'
    },{
      idTarea: '3',
      titulo: 'Tarea 3',
      cantidadPreguntas: '10',
      fechaLimite: '17-01-15',
      tiempoLimite: '10:00 horas',
      contenido: 'NroNaturales'
    },{
      idTarea: '4',
      titulo: 'Tarea 4',
      cantidadPreguntas: '10',
      fechaLimite: '17-01-15',
      tiempoLimite: '10:00 horas',
      contenido: 'NroNaturales'
    }
  ];

  constructor() { 

  }

  ngOnInit() {
  }


}
