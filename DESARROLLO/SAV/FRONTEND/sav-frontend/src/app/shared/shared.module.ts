import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NgZorroAntdModule} from 'ng-zorro-antd';
import {RouterModule} from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';

const MODULES = [CommonModule, RouterModule, NgZorroAntdModule, NgxPaginationModule];
const COMPONENTS = [];

@NgModule({
  imports: [...MODULES],
  exports: [...MODULES, ...COMPONENTS],
  declarations: [...COMPONENTS],
})
export class SharedModule {
}
