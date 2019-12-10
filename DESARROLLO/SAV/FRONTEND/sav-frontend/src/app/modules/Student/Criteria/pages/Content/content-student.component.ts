import {Component, OnInit} from '@angular/core';
import {ItemSubContent, SubContent} from "../../model/content-student.model";
import {ActivatedRoute, Router} from "@angular/router";
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

  subContent: SubContent

  constructor(private route: ActivatedRoute, private contentStudentService: ContentStudentService, private router: Router,) {
  }

  ngOnInit() {
    this.varIdContent = this.route.snapshot.paramMap.get('id').toString()
    this.getSubContent(this.varIdContent)
  }

  private async getSubContent(idContent: string) {
    try {
      this.varLoading = true
      const response: any = await this.contentStudentService.getSubContent(idContent).toPromise()
      this.subContent = response
      this.subContent.lsSubContenido = this.addFlag(this.subContent.lsSubContenido)
      this.varHeader.title = this.subContent.nombre
      this.varLoading = false
    } catch (e) {
      console.log(e)
    }
  }

  addFlag(lsSubContenido: ItemSubContent[]) {
    let arrayTem = []
    for (let item of lsSubContenido) {
      arrayTem.push({...item, flag: false})
    }
    return arrayTem
  }

  checkSubContent(item: ItemSubContent) {
    let id = `${this.varIdContent.toString()}-${item.idSubContenido.toString()}`
    this.router.navigate(['/student/criteria/content/resource/', id]);
  }

}
