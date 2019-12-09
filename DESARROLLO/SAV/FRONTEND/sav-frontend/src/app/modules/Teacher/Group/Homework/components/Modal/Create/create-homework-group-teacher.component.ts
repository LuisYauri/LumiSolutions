import {Component, Input, OnInit} from '@angular/core';
import {StudentsGlobalTeacherModel} from "../../../../../Global/Students/model/students-global-teacher.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NzModalRef, NzModalService} from "ng-zorro-antd/modal";
import {NzMessageService, NzNotificationService} from "ng-zorro-antd";
import {CriteriaStudentService} from "../../../../../../Student/Criteria/services/criteria-student.service";
import {Content, Criteria} from "../../../../../../Student/Criteria/model/criteria-student.model";
import {AuthService} from "../../../../../../../services/auth.service";
import {HomeworkGroupTeacherService} from "../../../services/homework-group-teacher.service";
import {QuestionsHomeworkGroupTeacherModel} from "../../../model/homework-group-teacher.model";
import * as moment from 'moment';

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
  listCriteria: Criteria[]
  listContent: Content[]
  dateFormat = 'dd/MM/yyyy';
  listQuestions: QuestionsHomeworkGroupTeacherModel[] = []
  varTitleCompetencia: string = ''
  varTitleContenido: string = ''
  varTitleGrado: string = ''
  jsonQuestionsCheck: { idPregunta: number } [] = []

  isAllChecked

  current = 0
  varStep =
    {
      title: [
        'Información General',
        'Asignar Preguntas',
      ],
    }

  varTableListTitle = []
  varFlagTableQuestions = true

  constructor(private modal: NzModalRef, private fb: FormBuilder, private nzMessageService: NzMessageService,
              private notification: NzNotificationService,
              private modalService: NzModalService,
              private criteriaStudentService: CriteriaStudentService,
              private authService: AuthService,
              private homeworkGroupTeacherService: HomeworkGroupTeacherService) {
  }

  ngOnInit() {
    this.getTitle()
    this.getValidateForms()
    this.selectNameAccion(this.idAccionModal)
    this.getListCriteria()
  }

  private getValidateForms() {
    this.dataHomeworkForm = this.fb.group({
      titulo: ['', [Validators.required]],
      idCompetencia: [null, [Validators.required]],
      idContenido: [null, [Validators.required]],
      fechaInicio: [null, [Validators.required]],
      fechaLimite: [null, [Validators.required]],
      tiempoLimite: [null, [Validators.required]],
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

  pre(): void {
    this.current -= 1
  }

  next(): void {
    this.current += 1
  }

  async getListCriteria() {
    try {
      const response: any = await this.criteriaStudentService.getListCriteria().toPromise()
      this.listCriteria = response
    } catch (e) {
      console.log(e)
    }
  }

  async getListContent(idCriterio: number) {
    this.jsonQuestionsCheck = []
    this.varFlagTableQuestions = true
    this.dataHomeworkForm.controls['idContenido'].setValue(null);
    try {
      const response: any = await this.criteriaStudentService.getListContent(idCriterio.toString()).toPromise()
      this.listContent = response
    } catch (e) {
      console.log(e)
    }
  }

  formatDate($event: any) {
    console.log($event)
  }

  changeContent($event: any) {
    const idCompetencia = this.dataHomeworkForm.controls['idCompetencia'].value
    const idContenido = this.dataHomeworkForm.controls['idContenido'].value
    this.jsonQuestionsCheck = []
    if (idContenido === null) {
    } else {
      this.getListQuestions(idCompetencia, idContenido)
    }
  }

  async getListQuestions(idCompetencia: string, idContenido: string) {
    this.varFlagTableQuestions = true
    try {
      const response: any = await this.homeworkGroupTeacherService.getListQuestions(idCompetencia, idContenido).toPromise()
      this.listQuestions = response
      if (this.listQuestions.length > 0) {
        this.varTitleCompetencia = this.listQuestions[0].nombreCriterio
        this.varTitleContenido = this.listQuestions[0].nombreContenido
        this.varTitleGrado = this.listQuestions[0].grado
      }
      this.varFlagTableQuestions = false
    } catch (e) {
      console.log(e)
      this.varFlagTableQuestions = false
    }
  }

  checkAll(value: boolean) {
    if (this.listQuestions.length > 0) {
      for (let item of this.listQuestions) {
        item.marcado = value
      }
      this.deleteItems(this.listQuestions)
    } else {

    }
  }

  private getTitle() {
    this.varTableListTitle = []
    this.varTableListTitle.push('Pregunta')
    this.varTableListTitle.push('Accion')
  }

  checkItem($event, item) {
    this.deleteItems(item)
  }

  deleteItems(data: any) {
    if (Array.isArray(data)) {
      this.jsonQuestionsCheck = []
      if (data[0].marcado) {
        for (let item of data) {
          this.jsonQuestionsCheck.push({idPregunta: item.idPregunta})
        }
      } else {
        this.jsonQuestionsCheck = []
      }
    } else {
      if (data.marcado) {
        this.jsonQuestionsCheck.push({idPregunta: data.idPregunta})
      } else {
        for (let i = 0; i < this.jsonQuestionsCheck.length; i++) {
          if (this.jsonQuestionsCheck[i].idPregunta === data.idPregunta) {
            this.jsonQuestionsCheck.splice(i, 1)
          }
        }
      }
    }
    console.log(this.jsonQuestionsCheck)
  }

  save() {

    if (!this.dataHomeworkForm.valid) {
      for (const i in this.dataHomeworkForm.controls) {
        this.dataHomeworkForm.controls[i].markAsDirty()
        this.dataHomeworkForm.controls[i].updateValueAndValidity()
      }
      this.notification.info('¡Ohh!', 'Complete todos los campos.')
      return
    } else {
      if (this.jsonQuestionsCheck.length > 0) {
        this.varLoadingData = true
        // console.log(this.generateJsonPostHomework())
        this.postHomework(this.generateJsonPostHomework())
      } else {
        this.notification.info('¡Ohh!', 'Preguntas Vacias.')
      }
    }


  }

  async postHomework(data: any) {
    try {
      await this.homeworkGroupTeacherService.postHomework(data).toPromise()
      this.modal.destroy({status: true})
      this.notification.create(
        'success',
        'Tarea creado correctamente',
        ''
      );
      this.varLoadingData = false
    } catch (e) {
      console.log(e)
    }
  }

  private generateJsonPostHomework() {
    return {
      titulo: this.dataHomeworkForm.controls['titulo'].value,
      idContenido: Number(this.dataHomeworkForm.controls['idContenido'].value),
      fechaInicio: this.generateDate(this.dataHomeworkForm.controls['fechaInicio'].value),
      fechaLimite: this.generateDate(this.dataHomeworkForm.controls['fechaLimite'].value),
      tiempoLimite: this.generateHour(this.dataHomeworkForm.controls['tiempoLimite'].value),
      lsPreguntas: this.convertArrayNumbers(this.jsonQuestionsCheck),
      idAula: this.authService.getAula().idAula
    }
  }

  generateDate(data: any) {
    return moment(data).format('DD/MM/YYYY')
  }

  generateHour(data: any) {
    return moment(data).format('HH:MM')
  }

  convertArrayNumbers(data: any) {
    let arrayNum = []
    for (let item of data) {
      arrayNum.push(Number(item.idPregunta))
    }
    return arrayNum
  }
}
