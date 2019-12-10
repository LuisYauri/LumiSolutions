import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ExamnStudent, QuestionsExamnStudent} from "../../model/examn-student.model";
import {NzModalService} from "ng-zorro-antd";
import {ExamnStudentService} from "../../services/examn-student.service";
import {ModalQuestionsExamnStudentComponent} from "../ModalQuestions/modal-questions-examn-student.component";

@Component({
  selector: 'app-table-list-examn-student',
  templateUrl: './table-list-examn-student.component.html',
  styleUrls: ['./table-list-examn-student.component.scss']
})
export class TableListExamnStudentComponent implements OnInit {

  @Input() items: ExamnStudent[]
  @Input() varLoading: boolean
  @Output() refresh = new EventEmitter();

  varTableTitle = ["Título", "Cantidad", "Fecha de Inicio", "Hora de Inicio", "Duración", "Accion"]
  questions:QuestionsExamnStudent

  constructor(private modalService: NzModalService,private examnStudentService:ExamnStudentService) { }

  ngOnInit() {
  }

  showModal(item: any) {
    this.getQuestions(item)
  }

  async getQuestions(item: ExamnStudent) {
    try {
      item.flag = true
      const response: any = await this.examnStudentService.getQuestions(item.idExamen.toString()).toPromise()
      item.flag = false
      this.questions = response
      this.generateModalQuestion()
    } catch (e) {
      item.flag = false
      console.log(e)
    }
  }

  private generateModalQuestion() {
    const modal = this.modalService.create({
      nzTitle: this.questions.titulo,
      nzContent: ModalQuestionsExamnStudentComponent,
      nzWidth: 700,
      nzComponentParams: {
        questions: this.questions
      },
      nzMaskClosable: false,
      nzClosable:false
    })
    modal.afterClose.subscribe((response: any) => {
      if (response === undefined) {
        return
      } else if (response.status) {
        this.refresh.emit({status: response.status})
      }
    })
  }
}
