import {Component, Input, OnInit} from '@angular/core';
import {MenuService} from "../../../mock/menu.service";

@Component({
  selector: 'app-menu-left-student',
  templateUrl: './menu-left-student.component.html',
  styleUrls: ['./menu-left-student.component.scss']
})
export class MenuLeftStudentComponent implements OnInit {

  @Input() isCollapsed: boolean = false;

  menus = MenuService.menuStudents();

  constructor() {
  }

  ngOnInit() {
  }

}
