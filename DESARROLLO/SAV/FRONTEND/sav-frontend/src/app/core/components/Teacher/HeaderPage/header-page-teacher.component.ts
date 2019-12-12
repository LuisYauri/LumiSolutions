import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header-page-teacher',
  templateUrl: './header-page-teacher.component.html',
  styleUrls: ['./header-page-teacher.component.scss']
})
export class HeaderPageTeacherComponent implements OnInit {

  @Input() title: string = ''
  @Input() icon: string = ''
  @Input() url: string = ''

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  redirect() {
    this.router.navigate([`${this.url}`]);
  }
}
