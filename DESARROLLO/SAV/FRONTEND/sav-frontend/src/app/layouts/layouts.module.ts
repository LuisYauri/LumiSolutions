import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {LoginComponent} from './Login/login.component';
import {StudentComponent} from './Student/student.component';
import {TeacherComponent} from './Teacher/Global/teacher.component';
import {CoreModule} from "../core/core.module";
import {ReactiveFormsModule} from "@angular/forms";
import {GroupTeacherComponent} from './Teacher/Group/group-teacher.component';

const COMPONENTS = [LoginComponent, StudentComponent, TeacherComponent, GroupTeacherComponent];

@NgModule({
  declarations: [...COMPONENTS],
  imports: [
    SharedModule,
    CoreModule,
    ReactiveFormsModule
  ],
  exports: [...COMPONENTS]
})
export class LayoutsModule {
}
