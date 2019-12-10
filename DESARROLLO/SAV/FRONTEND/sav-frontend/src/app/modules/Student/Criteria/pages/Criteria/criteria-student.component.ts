import {Component, OnInit} from '@angular/core';
import {Content, Criteria} from "../../model/criteria-student.model";
import {CriteriaStudentService} from "../../services/criteria-student.service";
import {ActivatedRoute, Router} from "@angular/router";



@Component({
  selector: 'app-criteria-student',
  templateUrl: './criteria-student.component.html',
  styleUrls: ['./criteria-student.component.scss']
})
export class CriteriaStudentComponent implements OnInit {

  varHeader = {
    title: 'Competencias',
    icon: 'copy',
    url: ''
  }
  varLoadingCriterio = true
  varLoadingContent = true

  varTitleCriterio = 'Competencias'
  varTitleCotenido = 'Contenidos'

  listCriteria: Criteria[]
  listContent: Content[]
  valueInitial= 0

  constructor(private criteriaStudentService: CriteriaStudentService,private route: ActivatedRoute,private router: Router) {
  }

  ngOnInit() {
    this.getListCriteria()
  }

  private async getListCriteria() {
    try {
      this.varLoadingCriterio = true
      const response: any = await this.criteriaStudentService.getListCriteria().toPromise()
      this.listCriteria = response
      this.varLoadingCriterio = false
    } catch (e) {
      this.varLoadingCriterio = false
      console.log(e)
    }
  }


  getCriterio($event: Criteria) {
    this.valueInitial= 1
    this.getListContent($event.idCriterio.toString())
  }

  getContent($event: Content) {
    this.router.navigate(['/student/criteria/content/',$event.idContenido.toString()]);
  }

  private async getListContent(idCriterio:string) {
    try {
      this.varLoadingContent = true
      const response: any = await this.criteriaStudentService.getListContent(idCriterio).toPromise()
      this.listContent = response
      this.varLoadingContent = false
    } catch (e) {
      this.varLoadingContent = false
      console.log(e)
    }
  }
}
