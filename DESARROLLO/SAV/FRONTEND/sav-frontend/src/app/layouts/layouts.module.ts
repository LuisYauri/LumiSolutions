import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './Login/login.component';
import { StudentComponent } from './Student/student.component';
import { TeacherComponent } from './Teacher/teacher.component';



@NgModule({
  declarations: [LoginComponent, StudentComponent, TeacherComponent],
  imports: [
    CommonModule
  ]
})
export class LayoutsModule { }
