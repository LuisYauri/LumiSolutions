import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {NzButtonModule} from 'ng-zorro-antd/button';
import {NzDatePickerModule} from 'ng-zorro-antd/date-picker';
import {NzIconModule} from 'ng-zorro-antd/icon';
import {NzTableModule} from 'ng-zorro-antd/table';
import {NzTabsModule} from 'ng-zorro-antd/tabs';

import {HistoryRoutingModule} from './history-student-routing.module';
import {HistoryStudentComponent} from './pages/History/history-student.component';

const CONST_PAGES = [HistoryStudentComponent]
const CONST_COMPONENTS = []
const CONST_ENTRY_COMPONENTS = []

@NgModule({
  declarations: [...CONST_COMPONENTS, ...CONST_PAGES],
  exports: [...CONST_COMPONENTS],
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
  entryComponents: [CONST_ENTRY_COMPONENTS]
})
export class HistoryStudentModule {
}
