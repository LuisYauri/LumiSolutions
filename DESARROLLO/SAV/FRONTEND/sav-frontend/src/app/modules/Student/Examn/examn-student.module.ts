import {NgModule} from '@angular/core'
import {CommonModule} from '@angular/common'
import {ExamnStudentComponent} from './pages/Examn/examn-student.component'
import {ExamnStudentRoutingModule} from "./examn-student-routing.module"
import {SharedModule} from "../../../shared/shared.module"
import {CoreModule} from "../../../core/core.module"
import {FormsModule, ReactiveFormsModule} from "@angular/forms"

const CONST_PAGES = [ExamnStudentComponent]
const CONST_COMPONENTS = []
const CONST_ENTRY_COMPONENTS = []

@NgModule({
  declarations: [...CONST_COMPONENTS, ...CONST_PAGES],
  exports: [...CONST_COMPONENTS],
  imports: [
    SharedModule,
    CommonModule,
    ExamnStudentRoutingModule,
    CoreModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [CONST_ENTRY_COMPONENTS]
})
export class ExamnStudentModule {
}
