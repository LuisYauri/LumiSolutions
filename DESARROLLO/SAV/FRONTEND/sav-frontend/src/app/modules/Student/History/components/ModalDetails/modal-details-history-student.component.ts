import {Component, Input, OnInit} from '@angular/core';
import {EvaluationHistoryStudent} from "../../model/history-student.model";
import {Resource} from "../../../../../core/model/Student/resource.model";
import {NzMessageService, NzModalRef, NzModalService, NzNotificationService} from "ng-zorro-antd";
import {FormBuilder} from "@angular/forms";
import {HomeworkStudentService} from "../../../Homework/services/homework-student.service";
import {AuthService} from "../../../../../services/auth.service";
import {Question} from "../../../Homework/model/homework-student.model";
import {ModalHelpStudentComponent} from "../../../../../core/components/Student/ModalHelp/modal-help-student.component";

@Component({
  selector: 'app-modal-details-history-student',
  templateUrl: './modal-details-history-student.component.html',
  styleUrls: ['./modal-details-history-student.component.scss']
})
export class ModalDetailsHistoryStudentComponent implements OnInit {

  @Input() questions: EvaluationHistoryStudent

  indexTab = 0
  resource: Resource

  varLoadingHelp = false

  constructor(private modal: NzModalRef, private nzMessageService: NzMessageService,
              private authService: AuthService,
              private notification: NzNotificationService,
              private modalService: NzModalService,
              private homeworkStudentService :HomeworkStudentService) { }

  ngOnInit() {
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

  destroyModal() {
    this.modal.destroy();
  }

  viewHelp(question: Question) {
    this.getHelp(question.idRecurso.toString())
  }

  private async getHelp(idRecurso: string) {
    try {
      this.varLoadingHelp = true
      const response:any = await this.homeworkStudentService.getResource(idRecurso).toPromise()
      this.resource = response
      this.varLoadingHelp = false
      this.generateModalHelp()
    }catch (e) {
      this.varLoadingHelp = false
      console.log(e)
    }
  }

  private generateModalHelp() {
    const modal = this.modalService.create({
      nzTitle: 'Ayuda',
      nzContent: ModalHelpStudentComponent,
      nzWidth: 750,
      nzComponentParams: {
        resource: this.resource
      },
      nzMaskClosable: false,
    })
  }
}
