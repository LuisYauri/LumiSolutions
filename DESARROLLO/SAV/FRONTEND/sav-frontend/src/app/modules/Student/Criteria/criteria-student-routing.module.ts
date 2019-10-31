import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CriteriaStudentComponent} from "./pages/Criteria/criteria-student.component";

const routes: Routes = [
  {
    path: '',
    component: CriteriaStudentComponent,
    data: {title:'Criteria'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CriteriaStudentRoutingModule {
}
