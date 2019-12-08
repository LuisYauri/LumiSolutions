import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./layouts/Login/login.component";
import {StudentComponent} from "./layouts/Student/student.component";
import {LayoutsModule} from "./layouts/layouts.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SharedModule} from "./shared/shared.module";
import {TeacherComponent} from "./layouts/Teacher/Global/teacher.component";


const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'student',
    component: StudentComponent,
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
  {path: 'teacher-global',
    component: TeacherComponent,
    children:[
      {
        path: 'classroom',
        loadChildren: 'src/app/modules/Teacher/Global/Classroom/classroom-global-teacher.module#ClassroomGlobalTeacherModule',
      },
      {
        path: 'students',
        loadChildren: 'src/app/modules/Teacher/Global/Students/students-global-teacher.module#StudentsGlobalTeacherModule',
      },
    ]
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
export class AppRoutingModule { }
