import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CriteriaStudentComponent} from "./pages/Criteria/criteria-student.component";
import {ContentStudentComponent} from "./pages/Content/content-student.component";

const routes: Routes = [
  {
    path: '',
    component: CriteriaStudentComponent,
    data: {title:'Criteria'}
  },
  {
    path: 'content/:id',
    component: ContentStudentComponent,
    data: {title:'Content'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CriteriaStudentRoutingModule {
}
