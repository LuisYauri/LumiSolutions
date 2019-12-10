import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SharedModule} from 'src/app/shared/shared.module';
import { MenuLeftStudentComponent } from './components/Student/MenuLeft/menu-left-student.component';
import { HeaderStudentComponent } from './components/Student/Header/header-student.component';
import { HeaderPageStudentComponent } from './components/Student/HeaderPage/header-page-student.component';
import { TitlePageStudentComponent } from './components/Student/TitlePage/title-page-student.component';
import { ModalHelpStudentComponent } from './components/Student/ModalHelp/modal-help-student.component';
import { SafeStudentPipe } from './pipe/Student/safe-student.pipe';
import { LoadingBlankStudentComponent } from './components/Student/LoadingBlank/loading-blank-student.component';
import { GlobalHeaderTeacherComponent } from './components/Teacher/Global/Header/global-header-teacher.component';
import { HeaderPageTeacherComponent } from './components/Teacher/HeaderPage/header-page-teacher.component';
import { LoadingBlankTeacherComponent } from './components/Teacher/LoadingBlank/loading-blank-teacher.component';
import { LoadingTeacherComponent } from './components/Teacher/Loading/loading-teacher.component';
import { DeleteModalTeacherComponent } from './components/Teacher/DeleteModal/delete-modal-teacher.component';
import { HeaderGroupTeacherComponent } from './components/Teacher/Group/Header/header-group-teacher.component';
import { MenuLeftGroupTeacherComponent } from './components/Teacher/Group/MenuLeft/menu-left-group-teacher.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

const COMPONENTS = [
  MenuLeftStudentComponent,
  HeaderStudentComponent,
  HeaderPageStudentComponent,
  TitlePageStudentComponent,
  ModalHelpStudentComponent,
  LoadingBlankStudentComponent,
  GlobalHeaderTeacherComponent,
  SafeStudentPipe,
  HeaderPageTeacherComponent,
  LoadingBlankTeacherComponent,
  LoadingTeacherComponent,
  DeleteModalTeacherComponent,
  HeaderGroupTeacherComponent,
  MenuLeftGroupTeacherComponent
];

@NgModule({
  declarations: [...COMPONENTS, NotFoundComponent, ],
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
  exports: [...COMPONENTS],
  entryComponents: [ModalHelpStudentComponent,DeleteModalTeacherComponent]
})
export class CoreModule { }
