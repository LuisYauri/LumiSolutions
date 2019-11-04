import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-homeworks',
  templateUrl: './homeworks.component.html',
  styleUrls: ['./homeworks.component.scss'],
})
export class HomeworksComponent implements OnInit {
  listOfData = [
    {
      key: '1',
      titulo: 'Tarea 1',
      cantidad: 10,
      fecha: '20/10/19',
      hora: '15:00 horas',
      contenido: 'Nro Naturales',
    },
    {
      key: '2',
      titulo: 'Tarea 2',
      cantidad: 20,
      fecha: '20/10/19',
      hora: '15:00 horas',
      contenido: 'Num Enteros',
    },
    {
      key: '3',
      titulo: 'Tarea 3',
      cantidad: 5,
      fecha: '15/11/19',
      hora: '14:00 horas',
      contenido: 'Ecuacion Lineal',
    },
  ];
  constructor() {}

  ngOnInit() {}
}
