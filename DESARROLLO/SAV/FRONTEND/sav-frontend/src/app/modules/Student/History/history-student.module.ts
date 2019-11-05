import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzTabsModule } from 'ng-zorro-antd/tabs';

import { ExamsComponent } from './pages/exams/exams.component';
import { HistoryRoutingModule } from './history-student-routing.module';
import { HistoryComponent } from './pages/history/history.component';
import { HomeworksComponent } from './components/homeworks/homeworks.component';

@NgModule({
  declarations: [HistoryComponent, HomeworksComponent, ExamsComponent],
  imports: [
    CommonModule,
    HistoryRoutingModule,
    NzTabsModule,
    NzDatePickerModule,
    FormsModule,
    NzButtonModule,
    NzIconModule,
    NzTableModule,
  ],
})
export class HistoryStudentModule {}
