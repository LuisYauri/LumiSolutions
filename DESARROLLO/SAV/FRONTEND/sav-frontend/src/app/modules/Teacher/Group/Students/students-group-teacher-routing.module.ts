import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentsGroupTeacherComponent} from "./pages/Students/students-group-teacher.component";

const routes: Routes = [
  {
    path: '',
    component: StudentsGroupTeacherComponent,
    data: {title:'StudentsGroupTeacher'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class StudentsGroupTeacherRoutingModule {
}
