import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SharedModule} from 'src/app/shared/shared.module';
import { MenuLeftStudentComponent } from './components/Student/MenuLeft/menu-left-student.component';
import { HeaderStudentComponent } from './components/Student/Header/header-student.component';
import { HeaderPageStudentComponent } from './components/Student/HeaderPage/header-page-student.component';
import { TitlePageStudentComponent } from './components/Student/TitlePage/title-page-student.component';

const COMPONENTS = [MenuLeftStudentComponent, HeaderStudentComponent, HeaderPageStudentComponent, TitlePageStudentComponent];

@NgModule({
  declarations: [...COMPONENTS],
  imports: [SharedModule, FormsModule, ReactiveFormsModule,],
  exports: [...COMPONENTS],
})
export class CoreModule { }
