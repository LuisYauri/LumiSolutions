import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {SharedModule} from '../../../shared/shared.module';
import {HomeworkStudentRoutingModule} from "./homework-student-routing.module";


@NgModule({
  declarations: [],
  imports: [
    SharedModule,
    CommonModule,
    HomeworkStudentRoutingModule
  ]
})
export class HomeworkStudentModule { }
