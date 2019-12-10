import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ExamnStudentComponent} from "./pages/Examn/examn-student.component";

const routes: Routes = [
  {
    path: '',
    component: ExamnStudentComponent,
    data: {title:'Examn'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ExamnStudentRoutingModule {
}
