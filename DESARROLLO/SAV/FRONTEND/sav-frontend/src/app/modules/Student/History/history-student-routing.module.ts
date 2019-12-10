import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HistoryStudentComponent} from "./pages/History/history-student.component";

const routes: Routes = [
  {
    path: '',
    component: HistoryStudentComponent,
    data: {title: 'History'},
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HistoryRoutingModule {}
