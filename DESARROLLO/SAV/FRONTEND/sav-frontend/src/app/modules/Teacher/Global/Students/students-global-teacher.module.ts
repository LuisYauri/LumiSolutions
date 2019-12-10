import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../../../shared/shared.module";
import {CoreModule} from "../../../../core/core.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {StudentsGlobalTeacherComponent} from "./pages/Students/students-global-teacher.component";
import {StudentsGlobalTeacherRoutingModule} from "./students-global-teacher-routing.module";
import {CreateStudentsGlobalTeacherComponent} from './components/Modal/Create/create-students-global-teacher.component';

const CONST_PAGES = [StudentsGlobalTeacherComponent, CreateStudentsGlobalTeacherComponent]
const CONST_COMPONENTS = []
const CONST_ENTRY_COMPONENTS = [CreateStudentsGlobalTeacherComponent]


@NgModule({
  declarations: [...CONST_COMPONENTS, ...CONST_PAGES],
  exports: [...CONST_COMPONENTS],
  imports: [
    SharedModule,
    CommonModule,
    StudentsGlobalTeacherRoutingModule,
    CoreModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [CONST_ENTRY_COMPONENTS]
})
export class StudentsGlobalTeacherModule {
}
