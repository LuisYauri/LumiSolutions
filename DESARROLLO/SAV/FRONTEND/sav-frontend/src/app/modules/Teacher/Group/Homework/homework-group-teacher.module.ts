import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeworkGroupTeacherComponent} from './pages/Homework/homework-group-teacher.component';
import {SharedModule} from "../../../../shared/shared.module";
import {CoreModule} from "../../../../core/core.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HomeworkGroupTeacherRoutingModule} from "./homework-group-teacher-routing.module";
import {CreateHomeworkGroupTeacherComponent} from './components/Modal/Create/create-homework-group-teacher.component';
import {ViewQuestionHomeworkGroupComponent} from './components/Modal/View/view-question-homework-group.component';

const CONST_PAGES = [HomeworkGroupTeacherComponent]
const CONST_COMPONENTS = [CreateHomeworkGroupTeacherComponent, ViewQuestionHomeworkGroupComponent]
const CONST_ENTRY_COMPONENTS = [CreateHomeworkGroupTeacherComponent, ViewQuestionHomeworkGroupComponent]


@NgModule({
  declarations: [...CONST_COMPONENTS, ...CONST_PAGES,],
  exports: [...CONST_COMPONENTS],
  imports: [
    SharedModule,
    CommonModule,
    HomeworkGroupTeacherRoutingModule,
    CoreModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [CONST_ENTRY_COMPONENTS]
})
export class HomeworkGroupTeacherModule {
}
