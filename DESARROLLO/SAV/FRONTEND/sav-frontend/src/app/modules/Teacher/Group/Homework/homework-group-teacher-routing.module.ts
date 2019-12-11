import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeworkGroupTeacherComponent} from "./pages/Homework/homework-group-teacher.component";

const routes: Routes = [
  {
    path: '',
    component: HomeworkGroupTeacherComponent,
    data: {title:'HomeworkGroupTeacher'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HomeworkGroupTeacherRoutingModule {
}
