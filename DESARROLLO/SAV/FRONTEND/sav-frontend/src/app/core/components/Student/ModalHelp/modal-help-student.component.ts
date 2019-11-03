import {Component, Input, OnInit} from '@angular/core';
import {Resource} from "../../../model/Student/resource.model";
import {AuthService} from "../../../../services/auth.service";
import {ResourceService} from "../../../services/Student/resource.service";

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

  constructor(private authService:AuthService, private resourceService:ResourceService) { }

  ngOnInit() {
    this.selectValue = this.resource.alumnoCalificacion
  }

  changeRate(value: number) {
    this.sendRate(value)
  }

  private async sendRate(value: number) {
    try {
      const response = await this.resourceService.postRate(this.gJsonSendRate(value)).toPromise()
      console.log("Good")
    }catch (e) {
      console.log(e)
    }
  }

  private gJsonSendRate(value: number) {
    return {
      idRecurso: this.resource.idRecurso,
      idEstudiante: this.authService.getIdEstudiante(),
      calificacion: value.toString()
    }
  }

  async sendComment() {
    try {
      const response = await this.resourceService.postComment(this.gJsonSendComment()).toPromise()
      console.log("Good")
    }catch (e) {
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
}
