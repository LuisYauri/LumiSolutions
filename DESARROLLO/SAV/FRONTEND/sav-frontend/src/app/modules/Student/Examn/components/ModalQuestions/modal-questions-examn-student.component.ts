import {Component, Input, OnInit} from '@angular/core'
import {QuestionExamnStudent, QuestionsExamnStudent, ResultsExamenStudent} from "../../model/examn-student.model"
import {FormBuilder, FormGroup} from "@angular/forms"
import {NzMessageService, NzModalRef, NzModalService, NzNotificationService} from "ng-zorro-antd";
import {AuthService} from "../../../../../services/auth.service";
import {ExamnStudentService} from "../../services/examn-student.service";
import {ModalResultsStudentComponent} from "../../../Homework/components/ModalResults/modal-results-student.component";

@Component({
  selector: 'app-modal-questions-examn-student',
  templateUrl: './modal-questions-examn-student.component.html',
  styleUrls: ['./modal-questions-examn-student.component.scss']
})
export class ModalQuestionsExamnStudentComponent implements OnInit {

  @Input() questions: QuestionsExamnStudent
  indexTab = 0
  answersForm: FormGroup
  varLoadingSend = false
  results: ResultsExamenStudent
  deadline = 0

  constructor(private modal: NzModalRef, private fb: FormBuilder, private nzMessageService: NzMessageService,
              private authService: AuthService, private notification: NzNotificationService,
              private modalService: NzModalService, private examnStudentService: ExamnStudentService) {
  }

  ngOnInit() {
    this.getAnswersForm()
    this.getHours()
  }

  pre(): void {
    this.indexTab -= 1;
  }

  next(): void {
    this.indexTab += 1;
  }

  pressTab($event: any) {
    this.indexTab = $event
  }

  private getAnswersForm() {
    this.answersForm = this.fb.group(this.gAnwersFrom())
  }

  gAnwersFrom() {
    let tempObject = {}
    for (let i = 0; i < this.questions.lsPreguntas.length; i++) {
      tempObject[i] = [''];
    }
    return tempObject
  }

  sendAnswers() {
    if (!this.answersForm.valid) {
      for (const i in this.answersForm.controls) {
        this.answersForm.controls[i].markAsDirty()
        this.answersForm.controls[i].updateValueAndValidity()
      }
      return
    } else {
      this.confirmationSend()
    }
  }

  private async confirmationSend() {
    try {
      this.varLoadingSend = true
      const response: any = await this.examnStudentService.postAnswers(this.questions.idExamen.toString(), this.gJsonSendAnswers(this.questions)).toPromise()
      this.varLoadingSend = false
      this.modal.destroy({status: true})
      this.results = response
      this.generateModalResults()
    } catch (e) {
      console.log(e)
      this.varLoadingSend = false
    }
  }

  private gJsonSendAnswers(questions: QuestionsExamnStudent) {
    return {
      idExamen: questions.idExamen,
      titulo: questions.titulo,
      duracion: questions.duracion,
      idEstudiante: this.authService.getIdStudent(),
      lsPreguntas: this.gJsonAnswers(questions.lsPreguntas)
    }
  }

  private gJsonAnswers(lsPreguntas: QuestionExamnStudent[]) {
    let tempArray = []
    for (let i = 0; i < lsPreguntas.length; i++) {
      tempArray.push({
        idPregunta: lsPreguntas[i].idPregunta,
        descripcion: lsPreguntas[i].descripcion,
        urlImagen: lsPreguntas[i].urlImagen,
        tipo: lsPreguntas[i].tipo,
        alternativas: lsPreguntas[i].alternativas,
        respuestaEstudiante: this.answersForm.controls[i].value
      })
    }
    return tempArray
  }

  private generateModalResults() {
    console.log(this.results)
    const modal = this.modalService.create({
      nzTitle: 'Resultados',
      nzContent: ModalResultsStudentComponent,
      nzWidth: 700,
      nzComponentParams: {
        results: this.results
      },
      nzMaskClosable: false,
    })
  }

  private getHours() {
    this.deadline = Date.now()+ 1000 * 60 * 60 * 10
  }
}
