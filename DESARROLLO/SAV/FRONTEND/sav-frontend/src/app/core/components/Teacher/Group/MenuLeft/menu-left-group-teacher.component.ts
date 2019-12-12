import {Component, Input, OnInit} from '@angular/core';
import {MenuService} from "../../../../mock/menu.service";

@Component({
  selector: 'app-menu-left-group-teacher',
  templateUrl: './menu-left-group-teacher.component.html',
  styleUrls: ['./menu-left-group-teacher.component.scss']
})
export class MenuLeftGroupTeacherComponent implements OnInit {

  @Input() isCollapsed: boolean = false;

  menus = MenuService.menuTeachers();

  constructor() { }

  ngOnInit() {
  }

}
