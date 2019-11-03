import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SharedModule} from '../../../shared/shared.module';
import {HomeworkStudentRoutingModule} from "./homework-student-routing.module";
import {HomeworkStudentComponent} from './pages/Homework/homework-student.component';
import {CoreModule} from "../../../core/core.module";
import { TableListHomeworksComponent } from './components/TableListHomeworks/table-list-homeworks.component';
import { ModalQuestionsComponent } from './components/ModalQuestions/modal-questions.component';


@NgModule({
  declarations: [HomeworkStudentComponent, TableListHomeworksComponent, ModalQuestionsComponent],
  imports: [
    SharedModule,
    CommonModule,
    HomeworkStudentRoutingModule,
    CoreModule
  ],
  entryComponents: [ModalQuestionsComponent]
})
export class HomeworkStudentModule {
}
