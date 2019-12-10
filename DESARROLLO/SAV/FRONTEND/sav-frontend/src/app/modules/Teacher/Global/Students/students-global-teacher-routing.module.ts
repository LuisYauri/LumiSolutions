import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentsGlobalTeacherComponent} from "./pages/Students/students-global-teacher.component";

const routes: Routes = [
  {
    path: '',
    component: StudentsGlobalTeacherComponent,
    data: {title:'StudentsGlobalTeacher'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class StudentsGlobalTeacherRoutingModule {
}
