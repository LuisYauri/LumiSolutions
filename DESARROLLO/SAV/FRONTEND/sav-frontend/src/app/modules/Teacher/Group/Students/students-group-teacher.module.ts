import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../../../shared/shared.module";
import {CoreModule} from "../../../../core/core.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {StudentsGroupTeacherRoutingModule} from "./students-group-teacher-routing.module";
import {CreateStudentsGroupTeacherComponent} from "./components/Modal/Create/create-students-group-teacher.component";
import {StudentsGroupTeacherComponent} from "./pages/Students/students-group-teacher.component";

const CONST_PAGES = [StudentsGroupTeacherComponent]
const CONST_COMPONENTS = [CreateStudentsGroupTeacherComponent]
const CONST_ENTRY_COMPONENTS = [CreateStudentsGroupTeacherComponent]


@NgModule({
  declarations: [...CONST_COMPONENTS, ...CONST_PAGES,],
  exports: [...CONST_COMPONENTS],
  imports: [
    SharedModule,
    CommonModule,
    StudentsGroupTeacherRoutingModule,
    CoreModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [CONST_ENTRY_COMPONENTS]
})
export class StudentsGroupTeacherModule {
}
