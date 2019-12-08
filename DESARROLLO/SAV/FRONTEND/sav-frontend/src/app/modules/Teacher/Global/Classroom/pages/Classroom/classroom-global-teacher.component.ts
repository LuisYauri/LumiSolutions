import {Component, OnInit} from '@angular/core';
import {ClassroomGlobalTeacherModel} from "../../model/classroom-global-teacher.model";
import {ClassroomGlobalTeacherService} from "../../services/classroom-global-teacher.service";
import {NzModalService, NzNotificationService} from "ng-zorro-antd";
import {CreateClassroomGlobalTeacherComponent} from "../../components/Modal/Create/create-classroom-global-teacher.component";
import {DeleteModalTeacherComponent} from "../../../../../../core/components/Teacher/DeleteModal/delete-modal-teacher.component";

@Component({
  selector: 'app-classroom-global-teacher',
  templateUrl: './classroom-global-teacher.component.html',
  styleUrls: ['./classroom-global-teacher.component.scss']
})
export class ClassroomGlobalTeacherComponent implements OnInit {

  varHeader = {
    title: 'Mis aulas',
    icon: 'profile',
    url: ''
  }

  varTitle = 'Lista de aulas'
  varLoading = true
  p: number = 1;
  listClassroom: ClassroomGlobalTeacherModel[]

  varTitleModal: string
  varAccionModal: number

  constructor(private classroomGlobalTeacherService: ClassroomGlobalTeacherService,
              private modalService: NzModalService,
              private notification: NzNotificationService,) {
  }

  ngOnInit() {
    this.getListClassroom()
  }

  async getListClassroom() {
    this. p= 1;
    this.varLoading = true
    try {
      const response: any = await this.classroomGlobalTeacherService.getListClassroom().toPromise()
      this.listClassroom = response
      this.varLoading = false
    } catch (e) {
      console.log(e)
    }
  }

  openAddAula() {
    this.varTitleModal = "Agregar Aula"
    this.varAccionModal = 1
    this.openModal(this.varTitleModal, this.varAccionModal)
  }

  openEditAula(item: ClassroomGlobalTeacherModel) {
    this.varTitleModal = "Editar Aula"
    this.varAccionModal = 2
    this.openModal(this.varTitleModal, this.varAccionModal, item)
  }

  openModal(title: string, idAccionModal: number, item?: ClassroomGlobalTeacherModel) {
    const modal = this.modalService.create({
      nzTitle: title,
      nzContent: CreateClassroomGlobalTeacherComponent,
      nzComponentParams: {
        idAccionModal: idAccionModal,
        item: item
      },
      nzWidth: 500,
      nzMaskClosable: false,
    })
    modal.afterClose.subscribe((response: any) => {
      if (response === undefined) {
        return
      } else if (response.status) {
        this.getListClassroom()
      }
    })
  }

  openDeleteAula(item: ClassroomGlobalTeacherModel) {
    const title = 'Eliminar Aula'
    const subtitle = '¿Está seguro de eliminar esta aula?'
    const description = 'Se eliminarán todos los datos relacionados a esta sección, no podrá recuperarlo después de realizar la acción.'
    this.openModalDelete(title, subtitle, description,item)

  }

  openModalDelete(title: string, subtitle: string, description: string,item?:ClassroomGlobalTeacherModel) {
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
        this.deleteClassroom(item.idAula.toString())
      }
    })
  }

  async deleteClassroom(id:string){
    try {
      this.varLoading = true
      await this.classroomGlobalTeacherService.deleteClassroom(id).toPromise()
      this.getListClassroom()
      this.notification.create(
        'success',
        'Aula eliminado correctamente',
        ''
      );
    }catch (e) {
      console.log(e)
      this.varLoading = false
    }
  }

}
