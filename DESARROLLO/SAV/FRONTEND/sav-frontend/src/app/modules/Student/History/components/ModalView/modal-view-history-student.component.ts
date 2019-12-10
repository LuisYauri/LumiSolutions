import {Component, Input, OnInit} from '@angular/core';
import {Results} from "../../../Homework/model/homework-student.model";
import {EvaluationHistoryStudent, ResultStatics} from "../../model/history-student.model";
import {NzModalRef, NzModalService} from "ng-zorro-antd";
import {ModalDetailsHistoryStudentComponent} from "../ModalDetails/modal-details-history-student.component";
import {HistoryStudentService} from "../../services/history-student.service";

@Component({
  selector: 'app-modal-view-history-student',
  templateUrl: './modal-view-history-student.component.html',
  styleUrls: ['./modal-view-history-student.component.scss']
})
export class ModalViewHistoryStudentComponent implements OnInit {

  @Input() results: ResultStatics

  varLoadingDetails: boolean = false
  questionsDetails: EvaluationHistoryStudent

  formatOne = (percent: number) => `${percent} %`;

  constructor(private modal: NzModalRef, private modalService: NzModalService,
              private historyStudentService: HistoryStudentService) {
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

  async openDetails() {
    try {
      this.varLoadingDetails = true
      const response: any = await this.historyStudentService.getResultsStaticsQuestions(this.results.idEvaluacion.toString()).toPromise()
      this.questionsDetails = response
      this.varLoadingDetails = false
      this.generateModalDetails()
    } catch (e) {
      this.varLoadingDetails = false
      console.log(e)
    }


  }

  private generateModalDetails() {

    const modal = this.modalService.create({
      nzTitle: 'Details',
      nzContent: ModalDetailsHistoryStudentComponent,
      nzWidth: 700,
      nzComponentParams: {
        questions: this.questionsDetails
      },
      nzMaskClosable: false,
    })
  }
}
