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
import {CoreModule} from "../../../core/core.module";
import {TabTareasHistoryStudentComponent} from './components/TabTareas/tab-tareas-history-student.component';
import {ModalViewHistoryStudentComponent} from './components/ModalView/modal-view-history-student.component';
import {SharedModule} from "../../../shared/shared.module";

const CONST_PAGES = [HistoryStudentComponent]
const CONST_COMPONENTS = [TabTareasHistoryStudentComponent, ModalViewHistoryStudentComponent]
const CONST_ENTRY_COMPONENTS = [ModalViewHistoryStudentComponent]

@NgModule({
  declarations: [...CONST_COMPONENTS, ...CONST_PAGES],
  exports: [...CONST_COMPONENTS],
  imports: [
    SharedModule,
    CommonModule,
    HistoryRoutingModule,
    FormsModule,
    CoreModule,
  ],
  entryComponents: [CONST_ENTRY_COMPONENTS]
})
export class HistoryStudentModule {
}
