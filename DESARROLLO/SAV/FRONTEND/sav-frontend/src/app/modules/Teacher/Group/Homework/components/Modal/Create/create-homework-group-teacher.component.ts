import {Component, Input, OnInit} from '@angular/core';
import {StudentsGlobalTeacherModel} from "../../../../../Global/Students/model/students-global-teacher.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NzModalRef, NzModalService} from "ng-zorro-antd/modal";
import {NzMessageService, NzNotificationService} from "ng-zorro-antd";

@Component({
  selector: 'app-create-homework-group-teacher',
  templateUrl: './create-homework-group-teacher.component.html',
  styleUrls: ['./create-homework-group-teacher.component.scss']
})
export class CreateHomeworkGroupTeacherComponent implements OnInit {

  @Input() idAccionModal: any = null
  @Input() item: any = null

  dataHomeworkForm: FormGroup
  varLoadingData = false
  nameAccion: string
  varEditIdItem: number

  constructor(private modal: NzModalRef, private fb: FormBuilder, private nzMessageService: NzMessageService,
              private notification: NzNotificationService,
              private modalService: NzModalService,) {
  }

  ngOnInit() {
    this.getValidateForms()
    this.selectNameAccion(this.idAccionModal)
  }

  private getValidateForms() {
    this.dataHomeworkForm = this.fb.group({
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
      // this.dataStudentForm.controls['nombre'].setValue(this.item.nombre);
      // this.dataStudentForm.controls['apaterno'].setValue(this.item.apaterno);
      // this.dataStudentForm.controls['amaterno'].setValue(this.item.amaterno);
      // this.dataStudentForm.controls['usuario'].setValue(this.item.usuario);
      // this.dataStudentForm.controls['contrasenia'].setValue(this.item.contrasenia);
      this.varEditIdItem = this.item.idEstudiante
    } else {
      this.nameAccion = 'Sin Accion'
    }
  }


}
