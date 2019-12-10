import {Component, Input, OnInit} from '@angular/core';
import {ResultStatics, TareaHistory} from "../../model/history-student.model";
import {HistoryStudentService} from "../../services/history-student.service";
import {NzModalService} from "ng-zorro-antd";
import {ModalQuestionsComponent} from "../../../Homework/components/ModalQuestions/modal-questions.component";
import {ModalResultsStudentComponent} from "../../../Homework/components/ModalResults/modal-results-student.component";
import {ModalViewHistoryStudentComponent} from "../ModalView/modal-view-history-student.component";

@Component({
  selector: 'app-tab-tareas-history-student',
  templateUrl: './tab-tareas-history-student.component.html',
  styleUrls: ['./tab-tareas-history-student.component.scss']
})
export class TabTareasHistoryStudentComponent implements OnInit {

  @Input() lsTareas: TareaHistory[]
  @Input() varLoading: boolean
  varTableTitle = ["Título", "Cantidad", "Fecha Realizada", "Hora Realizada", "Contenido", "Accion"]
  loadingBtn = false
  resultStatics: ResultStatics

  constructor(private historyStudentService: HistoryStudentService, private modalService: NzModalService) {
  }

  ngOnInit() {
  }

  showModal(tarea: TareaHistory) {
    this.loadingBtn = true
    this.getResultStatics(tarea)
  }

  private async getResultStatics(tarea: TareaHistory) {
    try {
      tarea.flag = true
      const response: any = await this.historyStudentService.getResultsStatics(tarea.idTarea.toString()).toPromise()
      this.resultStatics = response
      tarea.flag = false
      this.generateModalResults()
    } catch (e) {
      tarea.flag = false
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
