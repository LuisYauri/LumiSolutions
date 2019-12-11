import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SharedModule} from '../../../shared/shared.module';
import {CriteriaStudentRoutingModule} from "./criteria-student-routing.module";
import {CriteriaStudentComponent} from './pages/Criteria/criteria-student.component';
import {CoreModule} from "../../../core/core.module";

import { NguCarouselModule } from '@ngu/carousel';
import { CriteriaCarouselCriteriaComponent } from './components/Criteria/Carousel/Criteria/criteria-carousel-criteria.component';
import { ContentCarouselCriteriaComponent } from './components/Criteria/Carousel/Content/content-carousel-criteria.component';
import { ContentStudentComponent } from './pages/Content/content-student.component';
import { ResourceCriteriaStudentComponent } from './pages/Resource/resource-criteria-student.component';

const CRITERIA_PAGES = [CriteriaStudentComponent,ContentStudentComponent]
const CRITERIA_COMPONENTS = [CriteriaCarouselCriteriaComponent,ContentCarouselCriteriaComponent]
const CRITERIA_ENTRY_COMPONENTS=[]
@NgModule({
  exports: [...CRITERIA_COMPONENTS],
  entryComponents: [...CRITERIA_ENTRY_COMPONENTS],
  declarations: [...CRITERIA_PAGES, CRITERIA_COMPONENTS, ResourceCriteriaStudentComponent],
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
