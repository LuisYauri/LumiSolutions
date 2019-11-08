import {Component, Input, OnInit} from '@angular/core';
import {Comment, Resource} from "../../../model/Student/resource.model";
import {AuthService} from "../../../../services/auth.service";
import {ResourceService} from "../../../services/Student/resource.service";
import {NzModalRef} from "ng-zorro-antd";

@Component({
  selector: 'app-modal-help-student',
  templateUrl: './modal-help-student.component.html',
  styleUrls: ['./modal-help-student.component.scss']
})
export class ModalHelpStudentComponent implements OnInit {

  @Input() resource: Resource

  tooltips = ['Puede mejorar', 'Maso menos', 'Normal', 'Bueno', 'Maravilloso'];
  selectValue = 0;
  commentValue: string;
  listComment: Comment[] = []
  varLoadingSpinning = false

  constructor(private authService: AuthService, private resourceService: ResourceService, private modal: NzModalRef) {
  }

  ngOnInit() {
    this.selectValue = this.resource.alumnoCalificacion
    this.getComments(this.resource.idRecurso)
  }

  changeRate(value: number) {
    this.sendRate(value)
  }

  private async sendRate(value: number) {
    try {
      const response = await this.resourceService.postRate(this.gJsonSendRate(value)).toPromise()
      console.log("Good")
    } catch (e) {
      console.log(e)
    }
  }

  private gJsonSendRate(value: number) {
    return {
      idRecurso: this.resource.idRecurso,
      idEstudiante: this.authService.getIdEstudiante(),
      calificacion: value
    }
  }

  async sendComment() {
    try {
      this.varLoadingSpinning = true
      const response = await this.resourceService.postComment(this.gJsonSendComment()).toPromise()
      this.getComments(this.resource.idRecurso)
      this.varLoadingSpinning = false
      this.commentValue = ""
    } catch (e) {
      console.log(e)
    }
  }

  private gJsonSendComment() {
    return {
      idRecurso: this.resource.idRecurso,
      idEstudiante: this.authService.getIdEstudiante(),
      descripcion: this.commentValue.toString()
    }
  }


  private async getComments(idRecurso: number) {
    try {
      const response: any = await this.resourceService.getComments(idRecurso.toString()).toPromise()
      this.listComment = response
      console.log(this.listComment)
    } catch (e) {
      console.log(e)
    }
  }

  destroyModal() {
    this.modal.destroy();
  }
}
