import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SharedModule} from '../../../shared/shared.module';
import {HomeworkStudentRoutingModule} from "./homework-student-routing.module";
import {HomeworkStudentComponent} from './pages/Homework/homework-student.component';
import {CoreModule} from "../../../core/core.module";
import {TableListHomeworksComponent} from './components/TableList/table-list-homeworks.component';
import {ModalQuestionsComponent} from './components/ModalQuestions/modal-questions.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ModalResultsStudentComponent } from './components/ModalResults/modal-results-student.component';

const CONST_PAGES = [HomeworkStudentComponent]
const CONST_COMPONENTS = [TableListHomeworksComponent, ModalQuestionsComponent, ModalResultsStudentComponent]
const CONST_ENTRY_COMPONENTS=[ModalQuestionsComponent, ModalResultsStudentComponent]

@NgModule({
  declarations: [...CONST_COMPONENTS, ...CONST_PAGES],
  exports: [...CONST_COMPONENTS],
  imports: [
    SharedModule,
    CommonModule,
    HomeworkStudentRoutingModule,
    CoreModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [CONST_ENTRY_COMPONENTS]
})
export class HomeworkStudentModule {
}
