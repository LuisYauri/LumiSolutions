import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SharedModule} from 'src/app/shared/shared.module';
import { MenuLeftStudentComponent } from './components/Student/MenuLeft/menu-left-student.component';
import { HeaderStudentComponent } from './components/Student/Header/header-student.component';

const COMPONENTS = [MenuLeftStudentComponent, HeaderStudentComponent];

@NgModule({
  declarations: [...COMPONENTS],
  imports: [SharedModule, FormsModule, ReactiveFormsModule,],
  exports: [...COMPONENTS],
})
export class CoreModule { }
