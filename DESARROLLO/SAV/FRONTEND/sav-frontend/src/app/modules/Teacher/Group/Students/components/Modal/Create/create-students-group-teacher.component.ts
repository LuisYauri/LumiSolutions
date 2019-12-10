import {Component, OnInit} from '@angular/core';
import {MatricularStudentsGroupTeacherModel} from "../../../model/students-group-teacher.model";
import {StudentsGroupTeacherService} from "../../../services/students-group-teacher.service";
import {NzNotificationService} from "ng-zorro-antd";
import {NzModalRef} from "ng-zorro-antd/modal";

@Component({
  selector: 'app-create-students-group-teacher',
  templateUrl: './create-students-group-teacher.component.html',
  styleUrls: ['./create-students-group-teacher.component.scss']
})
export class CreateStudentsGroupTeacherComponent implements OnInit {

  varLoadingData = false
  listMatricularStudents: MatricularStudentsGroupTeacherModel []
  isAllChecked = false
  varTableListTitle = []
  jsonListMatriculaCheck = []


  constructor(private studentsGroupTeacherService: StudentsGroupTeacherService,
              private notification: NzNotificationService,
              private modal: NzModalRef) {
  }

  ngOnInit() {
    this.getTitle()
    this.getListStudentsMatricular()
  }

  getTitle() {
    this.varTableListTitle = []
    this.varTableListTitle.push('Nombre')
    this.varTableListTitle.push('Apellido Paterno')
    this.varTableListTitle.push('Apellido Materno')
    this.varTableListTitle.push('Usuario ')
  }

  async getListStudentsMatricular() {
    this.varLoadingData = true
    try {
      const response: any = await this.studentsGroupTeacherService.getListStudentsMatricular().toPromise()
      this.listMatricularStudents = response
      console.log(this.listMatricularStudents)
      this.varLoadingData = false
    } catch (e) {
      console.log(e)
      this.varLoadingData = false
    }
  }

  checkItem($event, item) {
    this.deleteItems(item)
  }

  checkAll(value: boolean) {
    if (this.listMatricularStudents.length > 0) {
      for (let item of this.listMatricularStudents) {
        item.marcado = value
      }
      this.deleteItems(this.listMatricularStudents)
    } else {

    }
  }

  deleteItems(data: any) {
    if (Array.isArray(data)) {
      this.jsonListMatriculaCheck = []
      if (data[0].marcado) {
        for (let item of data) {
          this.jsonListMatriculaCheck.push({idEstudiante: item.idEstudiante})
        }
      } else {
        this.jsonListMatriculaCheck = []
      }
    } else {
      if (data.marcado) {
        this.jsonListMatriculaCheck.push({idEstudiante: data.idEstudiante})
      } else {
        for (let i = 0; i < this.jsonListMatriculaCheck.length; i++) {
          if (this.jsonListMatriculaCheck[i].idEstudiante === data.idEstudiante) {
            this.jsonListMatriculaCheck.splice(i, 1)
          }
        }
      }
    }
  }

  sendData() {

    if (this.jsonListMatriculaCheck.length > 0) {
      this.varLoadingData = true
      this.postStudent(this.generateJsonPostStudent(this.jsonListMatriculaCheck))
    } else {
      this.notification.info('¡Ohh!', 'Estudiantes sin seleccionar.')
    }
  }

  private generateJsonPostStudent(data:any) {
    let arrayNum = []
    for (let item of data) {
      arrayNum.push(Number(item.idEstudiante))
    }
    return arrayNum
  }

  async postStudent(data:any) {
    this.varLoadingData = true
    try {
      console.log(data)
      await this.studentsGroupTeacherService.postStudentsMatricular(data).toPromise()
      this.modal.destroy({status: true})
      this.notification.create(
        'success',
        'Alumnos matriculados correctamente',
        ''
      );
      this.varLoadingData = false
    }catch (e) {
      console.log(e)
      this.varLoadingData = false
    }
  }
}
