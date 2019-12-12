import {Component, Input, OnInit} from '@angular/core';
import {Comment, Resource} from "../../../model/Student/resource.model";
import {AuthService} from "../../../../services/auth.service";
import {ResourceService} from "../../../services/Student/resource.service";
import {NzModalRef, NzNotificationService} from "ng-zorro-antd";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-modal-help-student',
  templateUrl: './modal-help-student.component.html',
  styleUrls: ['./modal-help-student.component.scss']
})
export class ModalHelpStudentComponent implements OnInit {

  @Input() resource: Resource

  tooltips = ['Puede mejorar', 'Maso menos', 'Normal', 'Bueno', 'Maravilloso'];
  selectValue = 0;
  listComment: Comment[] = []
  varLoadingSpinning = false

  commentForm: FormGroup

  constructor(private authService: AuthService, private resourceService: ResourceService,
              private modal: NzModalRef,private fb: FormBuilder,  private notification: NzNotificationService) {
  }

  ngOnInit() {
    console.log(this.resource)
    this.selectValue = this.resource.alumnoCalificacion
    this.getCommentForm()
    this.getComments(this.resource.idRecurso)
  }

  changeRate(value: number) {
    this.sendRate(value)
  }

  private async sendRate(value: number) {
    try {
      const response = await this.resourceService.postRate(this.gJsonSendRate(value)).toPromise()
    } catch (e) {
      console.log(e)
    }
  }

  private gJsonSendRate(value: number) {
    return {
      idRecurso: this.resource.idRecurso,
      idEstudiante: this.authService.getDataUsername().id,
      calificacion: value
    }
  }

  async sendComment() {
    try {
      this.varLoadingSpinning = true
      const response = await this.resourceService.postComment(this.gJsonSendComment()).toPromise()
      this.getComments(this.resource.idRecurso)
      this.varLoadingSpinning = false
      this.commentForm.controls['comment'].setValue(null);
      this.notification.create(
        'success',
        'Mensaje Enviado Correctamente',
        ''
      );
    } catch (e) {
      console.log(e)
    }
  }

  private gJsonSendComment() {
    return {
      idRecurso: this.resource.idRecurso,
      idEstudiante: this.authService.getDataUsername().id,
      descripcion: this.commentForm.controls['comment'].value.toString()
    }
  }


  private async getComments(idRecurso: number) {
    try {
      const response: any = await this.resourceService.getComments(idRecurso.toString()).toPromise()
      this.listComment = response
    } catch (e) {
      console.log(e)
    }
  }

  destroyModal() {
    this.modal.destroy();
  }

  private getCommentForm() {
    this.commentForm = this.fb.group({
      comment:['',[Validators.required]]
    })
  }

  sendFormComment() {
    if (!this.commentForm.valid) {
      for (const i in this.commentForm.controls) {
        this.commentForm.controls[i].markAsDirty()
        this.commentForm.controls[i].updateValueAndValidity()
      }
      this.notification.create(
        'info',
        'Debe Ingresar un comentario.',
        ''
      );
      return
    } else if (/^ *$/.test(this.commentForm.controls['comment'].value.toString())) {
      this.notification.create(
        'info',
        'Debe Ingresar un comentario.',
        ''
      );
    }
    else {
      this.sendComment()
    }
  }
}
