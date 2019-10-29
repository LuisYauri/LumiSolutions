import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {LoginComponent} from './Login/login.component';
import {StudentComponent} from './Student/student.component';
import {TeacherComponent} from './Teacher/teacher.component';
import {CoreModule} from "../core/core.module";

const COMPONENTS = [LoginComponent, StudentComponent, TeacherComponent];

@NgModule({
  declarations: [...COMPONENTS],
  imports: [
    SharedModule,
    CoreModule
  ],
  exports: [...COMPONENTS]
})
export class LayoutsModule {
}
