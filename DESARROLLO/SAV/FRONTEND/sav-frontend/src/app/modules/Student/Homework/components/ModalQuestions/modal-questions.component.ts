import { Component, OnInit, Input } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';

@Component({
  selector: 'app-modal-questions',
  templateUrl: './modal-questions.component.html',
  styleUrls: ['./modal-questions.component.scss']
})
export class ModalQuestionsComponent implements OnInit {
	
  homework = {
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

  constructor(private modal: NzModalRef) {
    
  }

  ngOnInit() {
    
  }

  destroyModal(): void {
    this.modal.destroy();
  }

}
