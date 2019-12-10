import {Component, OnInit} from '@angular/core';
import {StudentsGroupTeacherService} from "../../services/students-group-teacher.service";
import {StudentsGroupTeacherModel} from "../../model/students-group-teacher.model";
import {HomeworkGroupTeacherModel} from "../../../Homework/model/homework-group-teacher.model";
import {DeleteModalTeacherComponent} from "../../../../../../core/components/Teacher/DeleteModal/delete-modal-teacher.component";
import {NzModalService, NzNotificationService} from "ng-zorro-antd";

@Component({
  selector: 'app-students-group-teacher',
  templateUrl: './students-group-teacher.component.html',
  styleUrls: ['./students-group-teacher.component.scss']
})
export class StudentsGroupTeacherComponent implements OnInit {

  varHeader = {
    title: 'Estudiantes',
    icon: 'team',
    url: ''
  }

  varTitle = 'Lista de estudiantes'
  varLoading = false

  listStudents: StudentsGroupTeacherModel

  constructor(private studentsGroupTeacherService: StudentsGroupTeacherService,
              private modalService: NzModalService,
              private notification: NzNotificationService,
  ) {
  }

  ngOnInit() {
    this.getListStudents()
  }

  async getListStudents() {
    this.varLoading = true
    try {
      const response: any = await this.studentsGroupTeacherService.getListStudents().toPromise()
      this.listStudents = response
      this.varLoading = false
    } catch (e) {
      console.log(e)
      this.varLoading = false
    }
  }

  openDeleteStudents(item: StudentsGroupTeacherModel) {
    const title = 'Desmatricular al Alumno'
    const subtitle = '¿Está seguro de desmatricular al Alumno?'
    const description = 'Se eliminarán todos los datos relacionados con este Alumno, no podrá recuperarlo después de realizar la acción.'
    this.openModalDelete(title, subtitle, description, item)
  }

  openModalDelete(title: string, subtitle: string, description: string, item?: StudentsGroupTeacherModel) {
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
        this.deleteStudents(item.idEstudiante.toString())
      }
    })
  }

  async deleteStudents(idStudents: string) {
    try {
      this.varLoading = true
      await this.studentsGroupTeacherService.deleteStudents(idStudents).toPromise()
      this.getListStudents()
      this.notification.create(
        'success',
        'Alumno desmatriculado correctamente',
        ''
      );
    } catch (e) {
      console.log(e)
      this.varLoading = false
    }
  }
}
