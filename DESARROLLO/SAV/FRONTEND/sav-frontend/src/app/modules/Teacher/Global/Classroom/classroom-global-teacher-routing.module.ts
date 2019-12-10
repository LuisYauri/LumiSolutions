import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ClassroomGlobalTeacherComponent} from "./pages/Classroom/classroom-global-teacher.component";

const routes: Routes = [
  {
    path: '',
    component: ClassroomGlobalTeacherComponent,
    data: {title:'ClassroomGlobalTeacher'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClassroomGlobalTeacherRoutingModule {
}
