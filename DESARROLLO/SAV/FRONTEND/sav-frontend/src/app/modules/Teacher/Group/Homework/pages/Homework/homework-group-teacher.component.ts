import {Component, OnInit} from '@angular/core';
import {NzModalService, NzNotificationService} from "ng-zorro-antd";
import {CreateStudentsGlobalTeacherComponent} from "../../../../Global/Students/components/Modal/Create/create-students-global-teacher.component";
import {CreateHomeworkGroupTeacherComponent} from "../../components/Modal/Create/create-homework-group-teacher.component";

@Component({
  selector: 'app-homework-group-teacher',
  templateUrl: './homework-group-teacher.component.html',
  styleUrls: ['./homework-group-teacher.component.scss']
})
export class HomeworkGroupTeacherComponent implements OnInit {

  varHeader = {
    title: 'Tareas',
    icon: 'file-text',
    url: ''
  }

  varTitle = 'Lista de tareas'
  varLoading = false

  varTitleModal: string
  varAccionModal: number

  constructor(private modalService: NzModalService,
              private notification: NzNotificationService,) {
  }

  ngOnInit() {
  }

  openAddHomework() {
    this.varTitleModal = "Agregar Tarea"
    this.varAccionModal = 1
    this.openModalAddEdit(this.varTitleModal, this.varAccionModal)
  }

  openModalAddEdit(title: string, idAccionModal: number, item?: any) {
    const modal = this.modalService.create({
      nzTitle: title,
      nzContent: CreateHomeworkGroupTeacherComponent,
      nzComponentParams: {
        idAccionModal: idAccionModal,
        item: item
      },
      nzFooter: null,
      nzWidth: 800,
      nzMaskClosable: false,
    })
    modal.afterClose.subscribe((response: any) => {
      if (response === undefined) {
        return
      } else if (response.status) {
      }
    })
  }
}
