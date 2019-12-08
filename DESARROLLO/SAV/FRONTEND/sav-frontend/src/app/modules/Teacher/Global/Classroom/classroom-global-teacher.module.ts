import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../../../shared/shared.module";
import {CoreModule} from "../../../../core/core.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ClassroomGlobalTeacherComponent} from "./pages/Classroom/classroom-global-teacher.component";
import {ClassroomGlobalTeacherRoutingModule} from "./classroom-global-teacher-routing.module";

const CONST_PAGES = [ClassroomGlobalTeacherComponent]
const CONST_COMPONENTS = []
const CONST_ENTRY_COMPONENTS = []

@NgModule({
  declarations: [...CONST_COMPONENTS, ...CONST_PAGES],
  exports: [...CONST_COMPONENTS],
  imports: [
    SharedModule,
    CommonModule,
    ClassroomGlobalTeacherRoutingModule,
    CoreModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [CONST_ENTRY_COMPONENTS]
})
export class ClassroomGlobalTeacherModule {
}
