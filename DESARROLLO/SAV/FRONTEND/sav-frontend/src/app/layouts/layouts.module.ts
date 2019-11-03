import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {LoginComponent} from './Login/login.component';
import {StudentComponent} from './Student/student.component';
import {TeacherComponent} from './Teacher/teacher.component';
import {CoreModule} from "../core/core.module";
import {ReactiveFormsModule} from "@angular/forms";

const COMPONENTS = [LoginComponent, StudentComponent, TeacherComponent];

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
