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
  varLoading = false

  listHomeworks: Homework[] = []

  constructor(private homeworkStudentService:HomeworkStudentService) {
  }

  ngOnInit() {
    this.getListHomeworks()
  }


  private async getListHomeworks() {
    try {
      this.varLoading = true
      const response:any = await this.homeworkStudentService.getListHomework().toPromise()
      this.listHomeworks = this.generateJsonWithFlag(response)
      this.varLoading = false
    }catch (e) {
      this.varLoading = false
      console.log(e)
    }
  }

  private generateJsonWithFlag(response: Homework[]) {
    let jsonGenerate = []
    for (let home of response){
      jsonGenerate.push({...home, flag:false})
    }
    return jsonGenerate;
  }

  refresh($event: any) {
    if($event){
      this.getListHomeworks()
    }
  }
}
