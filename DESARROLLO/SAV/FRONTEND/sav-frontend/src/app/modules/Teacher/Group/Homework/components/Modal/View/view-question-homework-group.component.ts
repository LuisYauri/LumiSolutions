import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-view-question-homework-group',
  templateUrl: './view-question-homework-group.component.html',
  styleUrls: ['./view-question-homework-group.component.scss']
})
export class ViewQuestionHomeworkGroupComponent implements OnInit {
  @Input() description: string = null
  @Input() imageUrl: string = null

  constructor() {
  }

  ngOnInit() {
  }

}
