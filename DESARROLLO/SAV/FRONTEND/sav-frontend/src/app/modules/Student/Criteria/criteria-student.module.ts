import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SharedModule} from '../../../shared/shared.module';
import {CriteriaStudentRoutingModule} from "./criteria-student-routing.module";
import {CriteriaStudentComponent} from './pages/Criteria/criteria-student.component';
import {CoreModule} from "../../../core/core.module";

import { NguCarouselModule } from '@ngu/carousel';
import { CriteriaCarouselCriteriaComponent } from './components/Criteria/Carousel/Criteria/criteria-carousel-criteria.component';
import { ContentCarouselCriteriaComponent } from './components/Criteria/Carousel/Content/content-carousel-criteria.component';

const CRITERIA_PAGES = [CriteriaStudentComponent]
const CRITERIA_COMPONENTS = [CriteriaCarouselCriteriaComponent]
const CRITERIA_ENTRY_COMPONENTS=[]
@NgModule({
  exports: [...CRITERIA_COMPONENTS],
  entryComponents: [...CRITERIA_ENTRY_COMPONENTS],
  declarations: [...CRITERIA_PAGES, CRITERIA_COMPONENTS, ContentCarouselCriteriaComponent],
  imports: [
    SharedModule,
    CommonModule,
    CriteriaStudentRoutingModule,
    CoreModule,
    NguCarouselModule
  ]
})
export class CriteriaStudentModule {
}
