import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-loading-blank-student',
  templateUrl: './loading-blank-student.component.html',
  styleUrls: ['./loading-blank-student.component.scss']
})
export class LoadingBlankStudentComponent implements OnInit {

  @Input() flag:boolean = false
  constructor() { }

  ngOnInit() {
  }

}
