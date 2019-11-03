import { Component, OnInit } from '@angular/core';
import {Homework} from "../../model/homework-student.model";
import {HomeworkStudentService} from "../../services/homework-student.service";

@Component({
  selector: 'app-homework-student',
  templateUrl: './homework-student.component.html',
  styleUrls: ['./homework-student.component.scss']
})
export class HomeworkStudentComponent implements OnInit {

  varHeader = {
    title:'Tareas',
    icon:'file-text',
    url:''
  }

  varTitle = 'Lista de Tareas'
  varLoading = true

  listHomeworks: Homework[] = []

  constructor(private homeworkStudentService:HomeworkStudentService) {
  }

  ngOnInit() {
    this.getListHomeworks()
  }


  private async getListHomeworks() {
    try {
      const response:any = await this.homeworkStudentService.getListHomework().toPromise()
      this.listHomeworks = response
      this.varLoading = false
    }catch (e) {
      this.varLoading = false
      console.log(e)
    }
  }
}
