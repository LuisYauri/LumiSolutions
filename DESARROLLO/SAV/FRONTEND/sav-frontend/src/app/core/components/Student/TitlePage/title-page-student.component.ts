import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-title-page-student',
  templateUrl: './title-page-student.component.html',
  styleUrls: ['./title-page-student.component.scss']
})
export class TitlePageStudentComponent implements OnInit {

  @Input() title: string = ''

  constructor() { }

  ngOnInit() {
  }

}
