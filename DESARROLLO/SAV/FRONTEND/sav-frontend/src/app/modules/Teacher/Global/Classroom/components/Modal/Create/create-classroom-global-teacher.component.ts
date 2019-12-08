import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NzModalRef, NzModalService} from "ng-zorro-antd/modal";
import {NzMessageService, NzNotificationService} from "ng-zorro-antd";
import {ClassroomGlobalTeacherModel} from "../../../model/classroom-global-teacher.model";
import {ClassroomGlobalTeacherService} from "../../../services/classroom-global-teacher.service";

@Component({
  selector: 'app-create-classroom-global-teacher',
  templateUrl: './create-classroom-global-teacher.component.html',
  styleUrls: ['./create-classroom-global-teacher.component.scss']
})
export class CreateClassroomGlobalTeacherComponent implements OnInit {

  @Input() idAccionModal: any = null
  @Input() item: ClassroomGlobalTeacherModel = null

  dataAulaForm: FormGroup
  varLoadingData = false
  nameAccion: string
  varEditIdItem: number

  constructor(private modal: NzModalRef, private fb: FormBuilder, private nzMessageService: NzMessageService,
              private notification: NzNotificationService,
              private modalService: NzModalService,
              private classroomGlobalTeacherService: ClassroomGlobalTeacherService) {
  }

  ngOnInit() {
    this.getValidateForms()
    this.selectNameAccion(this.idAccionModal)
  }

  private getValidateForms() {
    this.dataAulaForm = this.fb.group({
      grupo: ['', [Validators.required]],
      codigoGrado: ['', [Validators.required]],
      anio: ['', [Validators.required]],
    })
  }

  selectNameAccion(id: number) {
    if (id === 1) {
      this.nameAccion = 'Agregar'
    } else if (id === 2) {
      this.nameAccion = 'Editar'
      this.dataAulaForm.controls['grupo'].setValue(this.item.grupo);
      this.dataAulaForm.controls['codigoGrado'].setValue(this.item.codigoGrado);
      this.dataAulaForm.controls['anio'].setValue(this.item.anio);
      this.varEditIdItem = this.item.idAula
    } else {
      this.nameAccion = 'Sin Accion'
    }
  }

  sendData() {

    if (!this.dataAulaForm.valid) {
      for (const i in this.dataAulaForm.controls) {
        this.dataAulaForm.controls[i].markAsDirty()
        this.dataAulaForm.controls[i].updateValueAndValidity()
      }
      this.notification.info('¡Ohh!', 'Complete todos los campos.')
      return
    } else {
      this.varLoadingData = true
      if (this.idAccionModal === 1) {
        this.postClassroom(this.generateJsonClassroom())
      } else if (this.idAccionModal === 2) {
        this.putClassroom(this.generateJsonClassroom())
      } else {
        console.log('No hay acción')
        this.varLoadingData = false
      }
    }
  }

  generateJsonClassroom() {
    if (this.idAccionModal === 1) {
      return {
        grupo: this.dataAulaForm.controls['grupo'].value,
        codigoGrado: this.dataAulaForm.controls['codigoGrado'].value,
        anio: this.dataAulaForm.controls['anio'].value,
      }
    } else if (this.idAccionModal === 2) {
      return {
        idAula: this.varEditIdItem,
        grupo: this.dataAulaForm.controls['grupo'].value,
        codigoGrado: this.dataAulaForm.controls['codigoGrado'].value,
        anio: this.dataAulaForm.controls['anio'].value,
      }
    } else {
      console.log('No hay acción')
    }
  }

  async postClassroom(data: any) {
    try {
      await this.classroomGlobalTeacherService.postClassroom(data).toPromise()
      this.modal.destroy({status: true})
      this.notification.create(
        'success',
        'Aula agredado correctamente',
        ''
      );
      this.varLoadingData = false
    } catch (e) {
      this.notification.info('¡Ohh!', 'Posiblemente el nombre del grupo se repite.')
      this.varLoadingData = false
      console.log(e)
    }
  }

  async putClassroom(data: any) {
    try {
      await this.classroomGlobalTeacherService.putClassroom(data).toPromise()
      this.modal.destroy({status: true})
      this.notification.create(
        'success',
        'Aula editado correctamente',
        ''
      );
      this.varLoadingData = false
    } catch (e) {
      console.log(e)
      this.varLoadingData = false
    }
  }


}
