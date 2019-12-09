import {Component, OnInit} from '@angular/core';
import {NzModalService, NzNotificationService} from "ng-zorro-antd";
import {CreateStudentsGlobalTeacherComponent} from "../../../../Global/Students/components/Modal/Create/create-students-global-teacher.component";
import {CreateHomeworkGroupTeacherComponent} from "../../components/Modal/Create/create-homework-group-teacher.component";
import {HomeworkGroupTeacherService} from "../../services/homework-group-teacher.service";
import {HomeworkGroupTeacherModel} from "../../model/homework-group-teacher.model";
import {StudentsGlobalTeacherModel} from "../../../../Global/Students/model/students-global-teacher.model";
import {DeleteModalTeacherComponent} from "../../../../../../core/components/Teacher/DeleteModal/delete-modal-teacher.component";

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
  listHomework: HomeworkGroupTeacherModel[]

  constructor(private modalService: NzModalService,
              private notification: NzNotificationService,
              private homeworkGroupTeacherService: HomeworkGroupTeacherService) {
  }

  ngOnInit() {
    this.getListHomework()
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
        this.getListHomework()
      }
    })
  }

  async getListHomework() {
    this.varLoading = true
    try {
      const response: any = await this.homeworkGroupTeacherService.getListHomework().toPromise()
      this.varLoading = false
      this.listHomework = response
      console.log(response)
    } catch (e) {
      this.varLoading = false
      console.log(e)
    }
  }

  openDeleteHomework(item: HomeworkGroupTeacherModel) {
    const title = 'Eliminar Tarea'
    const subtitle = '¿Está seguro de eliminar esta Tarea?'
    const description = 'Se eliminarán todos los datos relacionados con esta tarea, no podrá recuperarlo después de realizar la acción.'
    this.openModalDelete(title, subtitle, description, item)
  }

  openModalDelete(title: string, subtitle: string, description: string, item?: HomeworkGroupTeacherModel) {
    const modal = this.modalService.create({
      nzTitle: title,
      nzContent: DeleteModalTeacherComponent,
      nzFooter: null,
      nzComponentParams: {
        subtitle: subtitle,
        description: description
      },
      nzWidth: 500,
      nzMaskClosable: false,
    })
    modal.afterClose.subscribe((response: any) => {
      if (response === undefined) {
        return
      } else if (response.status) {
        this.deleteHomework(item.idTarea.toString())
      }
    })
  }

  async deleteHomework(idTarea: string) {
    try {
      this.varLoading = true
      await this.homeworkGroupTeacherService.deleteHomework(idTarea).toPromise()
      this.getListHomework()
      this.notification.create(
        'success',
        'Tarea eliminado correctamente',
        ''
      );
    } catch (e) {
      console.log(e)
      this.varLoading = false
    }
  }
}
