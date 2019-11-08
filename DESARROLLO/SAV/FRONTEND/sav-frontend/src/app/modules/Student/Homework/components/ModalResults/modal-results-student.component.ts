import {Component, Input, OnInit} from '@angular/core';
import {Results} from "../../model/homework-student.model";
import {NzModalRef} from "ng-zorro-antd";

@Component({
  selector: 'app-modal-results-student',
  templateUrl: './modal-results-student.component.html',
  styleUrls: ['./modal-results-student.component.scss']
})
export class ModalResultsStudentComponent implements OnInit {

  @Input() results: Results

  formatOne = (percent: number) => `${percent} %`;

  constructor(private modal: NzModalRef) {
  }

  ngOnInit() {
    console.log(this.results)
  }


  getColor(tipo: string) {
    if (tipo === 'Correcto') {
      return {'100%': '#52c41a'}
    } else if (tipo === 'Incorrecto') {
      return {'100%': '#f5222d'}
    } else if (tipo === 'Sin responder') {
      return {'100%': '#1890ff'}
    }
  }

  destroyModal() {
    this.modal.destroy();
  }
}
