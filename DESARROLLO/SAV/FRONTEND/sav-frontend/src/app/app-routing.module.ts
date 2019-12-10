import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from "./layouts/Login/login.component";
import {StudentComponent} from "./layouts/Student/student.component";
import {LayoutsModule} from "./layouts/layouts.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SharedModule} from "./shared/shared.module";
import {TeacherComponent} from "./layouts/Teacher/Global/teacher.component";
import {GroupTeacherComponent} from "./layouts/Teacher/Group/group-teacher.component";
import {TeacherGuard} from "./guards/teacher.guard";
import {StudentGuard} from "./guards/student.guard";
import {LoginGuard} from "./guards/login.guard";
import {NotFoundComponent} from "./core/components/not-found/not-found.component";


const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
    canActivate: [LoginGuard],
  },
  {
    path: 'student',
    component: StudentComponent,
    canActivate: [StudentGuard],
    children: [
      {
        path: 'homework',
        loadChildren: 'src/app/modules/Student/Homework/homework-student.module#HomeworkStudentModule',
      },
      {
        path: 'history',
        loadChildren: 'src/app/modules/Student/History/history-student.module#HistoryStudentModule',
      },
      {
        path: 'examn',
        loadChildren: 'src/app/modules/Student/Examn/examn-student.module#ExamnStudentModule',
      },
      {
        path: 'criteria',
        loadChildren: 'src/app/modules/Student/Criteria/criteria-student.module#CriteriaStudentModule',
      },
    ],
  },
  {
    path: 'teacher-global',
    component: TeacherComponent,
    canActivate: [TeacherGuard],
    children: [
      {
        path: 'classroom',
        loadChildren: 'src/app/modules/Teacher/Global/Classroom/classroom-global-teacher.module#ClassroomGlobalTeacherModule',
      },
      {
        path: 'students',
        loadChildren: 'src/app/modules/Teacher/Global/Students/students-global-teacher.module#StudentsGlobalTeacherModule',
      },
    ]
  },
  {
    path: 'teacher-group',
    component: GroupTeacherComponent,
    canActivate: [TeacherGuard],
    children: [
      {
        path: 'homework',
        loadChildren: 'src/app/modules/Teacher/Group/Homework/homework-group-teacher.module#HomeworkGroupTeacherModule',
      },
    ]
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
    LayoutsModule],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
