import {Component, OnInit} from '@angular/core';
import {ClassroomGlobalTeacherModel} from "../../model/classroom-global-teacher-model";
import {ClassroomGlobalTeacherService} from "../../services/classroom-global-teacher.service";

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
  varLoading = false
  p: number = 1;
  listClassroom: ClassroomGlobalTeacherModel[]

  constructor(private classroomGlobalTeacherService: ClassroomGlobalTeacherService) {
  }

  ngOnInit() {
    this.getListClassroom()
  }

  async getListClassroom() {
    try {
      const response: any = await this.classroomGlobalTeacherService.getListClassroom().toPromise()
      this.listClassroom = response
      console.log(this.listClassroom)
    } catch (e) {
      console.log(e)
    }
  }
}
