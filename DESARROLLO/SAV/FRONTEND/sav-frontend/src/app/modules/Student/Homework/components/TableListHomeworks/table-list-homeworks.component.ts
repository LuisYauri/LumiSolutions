import { Component, OnInit, Input } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd/modal';
import { ModalQuestionsComponent } from '../ModalQuestions/modal-questions.component';

@Component({
  selector: 'app-table-list-homeworks',
  templateUrl: './table-list-homeworks.component.html',
  styleUrls: ['./table-list-homeworks.component.scss']
})
export class TableListHomeworksComponent implements OnInit {

  @Input()
  items: any[];

  constructor(private modalService: NzModalService) {}

  ngOnInit() {
  }

  showModal(data): void {
  	console.log(data)
  	
  	var homework = {
	  "idTarea": 1,
	  "titulo": "Tarea 1",
	  "lsPreguntas": [
		{
		  "idPregunta": 1,
		  "idRecurso":1,
		  "descripcion": "Pregunta1",
		  "urlImagen": "URL Imagen",
		  "tipo": "0",
		  "alternativas": []
		},
		{
		  "idPregunta": 2,
		  "idRecurso":2,
		  "descripcion": "Pregunta1",
		  "urlImagen": "URL Imagen",
		  "tipo": "1",
		  "alternativas": ["10","20","30"]
		},
		{
		  "idPregunta": 3,
		  "idRecurso":3,
		  "descripcion": "Pregunta1",
		  "urlImagen": "URL Imagen",
		  "tipo": "0",
		  "alternativas": []
		}
	  ]
	}
	
    this.modalService.create({
      nzTitle: homework.titulo,
      nzContent: ModalQuestionsComponent
    });
  }

}
