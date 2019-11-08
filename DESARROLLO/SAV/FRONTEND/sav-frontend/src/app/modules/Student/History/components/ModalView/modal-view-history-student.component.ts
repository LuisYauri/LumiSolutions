import {Component, Input, OnInit} from '@angular/core';
import {Results} from "../../../Homework/model/homework-student.model";
import {ResultStatics} from "../../model/history-student.model";
import {NzModalRef} from "ng-zorro-antd";

@Component({
  selector: 'app-modal-view-history-student',
  templateUrl: './modal-view-history-student.component.html',
  styleUrls: ['./modal-view-history-student.component.scss']
})
export class ModalViewHistoryStudentComponent implements OnInit {

  @Input() results: ResultStatics

  formatOne = (percent: number) => `${percent} %`;

  constructor(private modal: NzModalRef) {
  }

  ngOnInit() {
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
