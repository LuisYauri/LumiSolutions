import { Component, OnInit } from '@angular/core';
import {SubContent} from "../../model/content-student.model";
import {ActivatedRoute} from "@angular/router";
import {ContentStudentService} from "../../services/content-student.service";

@Component({
  selector: 'app-content-student',
  templateUrl: './content-student.component.html',
  styleUrls: ['./content-student.component.scss']
})
export class ContentStudentComponent implements OnInit {

  varHeader = {
    title: '',
    icon: 'copy',
    url: '/student/criteria/'
  }

  varTitleSubcontent = "Temas"

  varLoading = true
  varIdContent = ""

  subContent:SubContent

  constructor(private route: ActivatedRoute, private contentStudentService:ContentStudentService) { }

  ngOnInit() {
    this.varIdContent = this.route.snapshot.paramMap.get('id').toString()
    this.getSubContent(this.varIdContent)
  }

  private async getSubContent(idContent:string) {
    try {
      this.varLoading = true
      const response:any = await this.contentStudentService.getSubContent(idContent).toPromise()
      this.subContent = response
      this.varHeader.title = this.subContent.nombre
      this.varLoading = false
    }catch (e) {
      console.log(e)
    }
  }
}
