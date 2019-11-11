import {Component, OnInit} from '@angular/core';
import {ExamnStudent} from "../../model/examn-student.model";
import {ExamnStudentService} from "../../services/examn-student.service";

@Component({
  selector: 'app-examn-student',
  templateUrl: './examn-student.component.html',
  styleUrls: ['./examn-student.component.scss']
})
export class ExamnStudentComponent implements OnInit {

  varHeader = {
    title: 'Exámenes',
    icon: 'profile',
    url: ''
  }

  listExamn: ExamnStudent[]

  varTitle = 'Lista de Examenes'
  varLoading = false

  constructor(private examnStudentService: ExamnStudentService) {
  }

  ngOnInit() {
    this.getListExamn()
  }

  refresh($event: any) {
    if ($event) {
      this.getListExamn()
    }
  }

  private async getListExamn() {
    try {
      this.varLoading = true
      const response: any = await this.examnStudentService.getListExamn().toPromise()
      this.listExamn = this.generateJsonWithFlag(response)
      this.varLoading = false
    } catch (e) {
      this.varLoading = false
      console.log(e)
    }
  }

  private generateJsonWithFlag(response: ExamnStudent[]) {
    let jsonGenerate = []
    for (let home of response) {
      jsonGenerate.push({...home, flag: false})
    }
    return jsonGenerate;
  }
}
