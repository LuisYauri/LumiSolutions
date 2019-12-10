import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-loading-teacher',
  templateUrl: './loading-teacher.component.html',
  styleUrls: ['./loading-teacher.component.scss']
})
export class LoadingTeacherComponent implements OnInit {

  @Input('varLoading') varLoading: boolean

  constructor() {
  }

  ngOnInit() {
  }

}
