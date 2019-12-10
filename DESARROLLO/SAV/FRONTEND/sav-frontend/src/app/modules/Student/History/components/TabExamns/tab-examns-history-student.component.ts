import {Component, Input, OnInit} from '@angular/core';
import {ExamenHistory, ResultStatics, TareaHistory} from "../../model/history-student.model";
import {HistoryStudentService} from "../../services/history-student.service";
import {NzModalService} from "ng-zorro-antd";
import {ModalViewHistoryStudentComponent} from "../ModalView/modal-view-history-student.component";

@Component({
  selector: 'app-tab-examns-history-student',
  templateUrl: './tab-examns-history-student.component.html',
  styleUrls: ['./tab-examns-history-student.component.scss']
})
export class TabExamnsHistoryStudentComponent implements OnInit {

  @Input() lsTareas: ExamenHistory[]
  @Input() varLoading: boolean
  varTableTitle = ["Título", "Cantidad", "Fecha Realizada", "Hora Realizada", "Accion"]
  resultStatics: ResultStatics

  constructor(private historyStudentService: HistoryStudentService, private modalService: NzModalService) {
  }

  ngOnInit() {
  }

  showModal(examn: ExamenHistory) {
    this.getResultStatics(examn)
  }

  private async getResultStatics(examn: ExamenHistory) {
    try {
      examn.flag = true
      const response: any = await this.historyStudentService.getResultsStatics(examn.idExamen.toString()).toPromise()
      this.resultStatics = response
      examn.flag = false
      this.generateModalResults()
    } catch (e) {
      examn.flag = false
      console.log(e)
    }
  }

  private generateModalResults() {
    const modal = this.modalService.create({
      nzTitle: 'Resultados',
      nzContent: ModalViewHistoryStudentComponent,
      nzWidth: 700,
      nzComponentParams: {
        results: this.resultStatics
      },
      nzMaskClosable: false,
    })
  }


}
