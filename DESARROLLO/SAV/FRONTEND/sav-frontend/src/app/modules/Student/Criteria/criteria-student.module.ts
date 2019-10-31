import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SharedModule} from '../../../shared/shared.module';
import {CriteriaStudentRoutingModule} from "./criteria-student-routing.module";
import {CriteriaStudentComponent} from './pages/Criteria/criteria-student.component';
import {CoreModule} from "../../../core/core.module";


@NgModule({
  declarations: [CriteriaStudentComponent],
  imports: [
    SharedModule,
    CommonModule,
    CriteriaStudentRoutingModule,
    CoreModule
  ]
})
export class CriteriaStudentModule {
}
