import {Component, Input, OnInit} from '@angular/core';
import {Results} from "../../model/homework-student.model";

@Component({
  selector: 'app-modal-results-student',
  templateUrl: './modal-results-student.component.html',
  styleUrls: ['./modal-results-student.component.scss']
})
export class ModalResultsStudentComponent implements OnInit {

  @Input() results: Results

  constructor() { }

  ngOnInit() {
    console.log(this.results)
  }

}
