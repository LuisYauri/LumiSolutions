import {Component, Input, OnInit} from '@angular/core';
import {ClassroomGlobalTeacherModel} from "../../../../Classroom/model/classroom-global-teacher.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NzModalRef, NzModalService} from "ng-zorro-antd/modal";
import {NzMessageService, NzNotificationService} from "ng-zorro-antd";
import {StudentsGlobalTeacherService} from "../../../services/students-global-teacher.service";
import {StudentsGlobalTeacherModel} from "../../../model/students-global-teacher.model";

@Component({
  selector: 'app-create-students-global-teacher',
  templateUrl: './create-students-global-teacher.component.html',
  styleUrls: ['./create-students-global-teacher.component.scss']
})
export class CreateStudentsGlobalTeacherComponent implements OnInit {

  @Input() idAccionModal: any = null
  @Input() item: StudentsGlobalTeacherModel = null

  dataStudentForm: FormGroup
  varLoadingData = false
  nameAccion: string
  varEditIdItem: number

  constructor(private modal: NzModalRef, private fb: FormBuilder, private nzMessageService: NzMessageService,
              private notification: NzNotificationService,
              private modalService: NzModalService,
              private studentsGlobalTeacherService: StudentsGlobalTeacherService
  ) {
  }

  ngOnInit() {
    this.getValidateForms()
    this.selectNameAccion(this.idAccionModal)
  }

  private getValidateForms() {
    this.dataStudentForm = this.fb.group({
      nombre: ['', [Validators.required]],
      apaterno: ['', [Validators.required]],
      amaterno: ['', [Validators.required]],
      usuario: ['', [Validators.required]],
      contrasenia: ['', [Validators.required]],
    })
  }

  selectNameAccion(id: number) {
    if (id === 1) {
      this.nameAccion = 'Agregar'
    } else if (id === 2) {
      this.nameAccion = 'Editar'
      this.dataStudentForm.controls['nombre'].setValue(this.item.nombre);
      this.dataStudentForm.controls['apaterno'].setValue(this.item.apaterno);
      this.dataStudentForm.controls['amaterno'].setValue(this.item.amaterno);
      this.dataStudentForm.controls['usuario'].setValue(this.item.usuario);
      this.dataStudentForm.controls['contrasenia'].setValue(this.item.contrasenia);
      this.varEditIdItem = this.item.idEstudiante
    } else {
      this.nameAccion = 'Sin Accion'
    }
  }

  sendData() {

    if (!this.dataStudentForm.valid) {
      for (const i in this.dataStudentForm.controls) {
        this.dataStudentForm.controls[i].markAsDirty()
        this.dataStudentForm.controls[i].updateValueAndValidity()
      }
      this.notification.info('¡Ohh!', 'Complete todos los campos.')
      return
    } else {
      this.varLoadingData = true
      if (this.idAccionModal === 1) {
        this.postStudents(this.generateJsonStudents())
      } else if (this.idAccionModal === 2) {
        this.putStudents(this.generateJsonStudents())
      } else {
        console.log('No hay acción')
        this.varLoadingData = false
      }
    }
  }

  private generateJsonStudents() {
    if (this.idAccionModal === 1) {
      return {
        nombre: this.dataStudentForm.controls['nombre'].value,
        apaterno: this.dataStudentForm.controls['apaterno'].value,
        amaterno: this.dataStudentForm.controls['amaterno'].value,
        usuario: this.dataStudentForm.controls['usuario'].value,
        contrasenia: this.dataStudentForm.controls['contrasenia'].value,
      }
    } else if (this.idAccionModal === 2) {
      return {
        idEstudiante: this.varEditIdItem,
        nombre: this.dataStudentForm.controls['nombre'].value,
        apaterno: this.dataStudentForm.controls['apaterno'].value,
        amaterno: this.dataStudentForm.controls['amaterno'].value,
        usuario: this.dataStudentForm.controls['usuario'].value,
        contrasenia: this.dataStudentForm.controls['contrasenia'].value,
      }
    } else {
      console.log('No hay acción')
    }
  }

  async postStudents(data: any) {
    try {
      await this.studentsGlobalTeacherService.postStudents(data).toPromise()
      this.modal.destroy({status: true})
      this.notification.create(
        'success',
        'Estudiante agregado correctamente',
        ''
      );
      this.varLoadingData = false
    } catch (e) {
      this.notification.info('¡Ohh!', 'Algo esta fallando.')
      this.varLoadingData = false
      console.log(e)
    }
  }

  async putStudents(data: any) {
    try {
      await this.studentsGlobalTeacherService.putStudents(data).toPromise()
      this.modal.destroy({status: true})
      this.notification.create(
        'success',
        'Estudiante editado correctamente',
        ''
      );
      this.varLoadingData = false
    } catch (e) {
      console.log(e)
      this.varLoadingData = false
    }
  }

}
