import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-header-page-student',
  templateUrl: './header-page-student.component.html',
  styleUrls: ['./header-page-student.component.scss']
})
export class HeaderPageStudentComponent implements OnInit {

  @Input() title: string = ''
  @Input() icon: string = ''
  @Input() url: string = ''

  constructor() {
  }

  ngOnInit() {
  }

}
