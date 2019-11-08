import {Component, OnInit} from '@angular/core';
import {HistoryStudentService} from "../../services/history-student.service";
import {ListHistory} from "../../model/history-student.model";

@Component({
  selector: 'app-history-student',
  templateUrl: './history-student.component.html',
  styleUrls: ['./history-student.component.scss']
})
export class HistoryStudentComponent implements OnInit {

  varHeader = {
    title: 'Historial',
    icon: 'read',
    url: ''
  }

  varLoading = true

  listHistory: ListHistory = {lsTareas: [], lsExamenes:[]}

  constructor(private historyStudentService: HistoryStudentService) {
  }

  ngOnInit() {
    this.getListHistory()
  }

  async getListHistory() {
    try {
      const response: any = await this.historyStudentService.getListHistory().toPromise()
      this.listHistory = response
      this.varLoading = false
    } catch (e) {
      console.log(e)
      this.varLoading = false
    }
  }

}
