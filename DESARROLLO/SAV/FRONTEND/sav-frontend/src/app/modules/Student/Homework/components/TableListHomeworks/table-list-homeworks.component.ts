import {Component, OnInit, Input} from '@angular/core';
import {NzModalService} from 'ng-zorro-antd/modal';
import {ModalQuestionsComponent} from '../ModalQuestions/modal-questions.component';
import {Homework, Questions} from "../../model/homework-student.model";
import {HomeworkStudentService} from "../../services/homework-student.service";

@Component({
  selector: 'app-table-list-homeworks',
  templateUrl: './table-list-homeworks.component.html',
  styleUrls: ['./table-list-homeworks.component.scss']
})
export class TableListHomeworksComponent implements OnInit {

  @Input() items: Homework[];
  @Input() varLoading: boolean;

  varTableTitle = ["Título", "Cantidad", "Fecha(Límite)", "Tiempo(Límite)", "Contenido", "Accion"]
  questions: Questions
  loadingBtn = false

  constructor(private modalService: NzModalService, private homeworkStudentService: HomeworkStudentService) {
  }

  ngOnInit() {

  }

  showModal(item: Homework) {
    this.loadingBtn = true
    this.getQuestions(item.idTarea.toString())
  }

  async getQuestions(idTarea: string) {
    try {
      const response: any = await this.homeworkStudentService.getQuestions(idTarea).toPromise()
      this.questions = response
      this.loadingBtn = false
      this.generateModal()

    } catch (e) {
      this.loadingBtn = false
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
