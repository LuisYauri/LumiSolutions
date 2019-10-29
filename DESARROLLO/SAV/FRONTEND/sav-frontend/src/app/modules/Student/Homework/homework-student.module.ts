import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SharedModule} from '../../../shared/shared.module';
import {HomeworkStudentRoutingModule} from "./homework-student-routing.module";
import {HomeworkStudentComponent} from './pages/Homework/homework-student.component';


@NgModule({
  declarations: [HomeworkStudentComponent],
  imports: [
    SharedModule,
    CommonModule,
    HomeworkStudentRoutingModule
  ]
})
export class HomeworkStudentModule {
}
