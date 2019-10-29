import { NgModule } from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './Login/login.component';
import { StudentComponent } from './Student/student.component';
import { TeacherComponent } from './Teacher/teacher.component';

const COMPONENTS = [LoginComponent, StudentComponent, TeacherComponent];

@NgModule({
  declarations: [...COMPONENTS],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports:[...COMPONENTS]
})
export class LayoutsModule { }
