import {Component, OnInit, Input} from '@angular/core'
import {NzModalService} from 'ng-zorro-antd/modal'
import {ModalQuestionsComponent} from '../ModalQuestions/modal-questions.component'
import {Homework, Questions} from "../../model/homework-student.model"
import {HomeworkStudentService} from "../../services/homework-student.service"

@Component({
  selector: 'app-table-list-homeworks',
  templateUrl: './table-list-homeworks.component.html',
  styleUrls: ['./table-list-homeworks.component.scss']
})
export class TableListHomeworksComponent implements OnInit {

  @Input() items: Homework[]
  @Input() varLoading: boolean

  varTableTitle = ["Título", "Cantidad", "Fecha(Límite)", "Tiempo(Límite)", "Contenido", "Accion"]
  questions: Questions

  constructor(private modalService: NzModalService, private homeworkStudentService: HomeworkStudentService) {
  }

  ngOnInit() {

  }

  showModal(item: Homework) {
    this.getQuestions(item)
  }

  async getQuestions(item: Homework) {
    try {
      item.flag = true
      const response: any = await this.homeworkStudentService.getQuestions(item.idTarea.toString()).toPromise()
      item.flag = false
      this.questions = response
      this.generateModal()
    } catch (e) {
      item.flag = false
      console.log(e)
    }
  }


  private generateModal() {
    const modal = this.modalService.create({
      nzTitle: this.questions.titulo,
      nzContent: ModalQuestionsComponent,
      nzWidth: 700,
      nzComponentParams: {
        questions: this.questions
      },
      nzMaskClosable: false,
    })
  }
}
