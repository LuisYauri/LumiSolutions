import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-loading-blank-teacher',
  templateUrl: './loading-blank-teacher.component.html',
  styleUrls: ['./loading-blank-teacher.component.scss']
})
export class LoadingBlankTeacherComponent implements OnInit {

  @Input() flag: boolean = false

  constructor() {
  }

  ngOnInit() {
  }

}
