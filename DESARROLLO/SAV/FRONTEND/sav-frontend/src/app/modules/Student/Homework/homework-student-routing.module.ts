import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeworkStudentComponent} from "./pages/Homework/homework-student.component";

const routes: Routes = [
  {
    path: '',
    component: HomeworkStudentComponent,
    data: {title:'HomeWork'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HomeworkStudentRoutingModule {
}
