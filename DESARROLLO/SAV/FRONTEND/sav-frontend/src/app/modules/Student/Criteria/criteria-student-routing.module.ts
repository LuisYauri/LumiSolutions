import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CriteriaStudentComponent} from "./pages/Criteria/criteria-student.component";
import {ContentStudentComponent} from "./pages/Content/content-student.component";
import {ResourceCriteriaStudentComponent} from "./pages/Resource/resource-criteria-student.component";

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
  },
  {
    path: 'content/resource/:id',
    component: ResourceCriteriaStudentComponent,
    data: {title:'Resource'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CriteriaStudentRoutingModule {
}
