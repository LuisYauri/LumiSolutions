import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ResourceStudentService} from "../../services/resource-student.service";
import {ResourceStudentModel} from "../../model/resource-student.model";
import {ItemSubContent} from "../../model/content-student.model";
import {HomeworkStudentService} from "../../../Homework/services/homework-student.service";
import {ModalHelpStudentComponent} from "../../../../../core/components/Student/ModalHelp/modal-help-student.component";
import {NzModalService} from "ng-zorro-antd/modal";
import {DataCriteriaStudentService} from "../../services/data-criteria-student.service";

@Component({
  selector: 'app-resource-criteria-student',
  templateUrl: './resource-criteria-student.component.html',
  styleUrls: ['./resource-criteria-student.component.scss']
})
export class ResourceCriteriaStudentComponent implements OnInit {

  varHeader = {
    title: 'Recursos',
    icon: 'copy',
    url: '/student/criteria/content'
  }

  varTitleResource = "Lista de recursos "

  varLoading = true
  varIdResource = ""
  varidContent = ""
  resource: ResourceStudentModel[]

  constructor(private route: ActivatedRoute, private resourceStudentService: ResourceStudentService,
              private homeworkStudentService: HomeworkStudentService, private modalService: NzModalService) {
  }

  ngOnInit() {
    let arrayID = this.route.snapshot.paramMap.get('id').toString().split("-")
    this.varidContent = arrayID[0]
    this.varIdResource = arrayID[1]
    this.varHeader.url = `/student/criteria/content/${this.varidContent}`
    this.getResource(this.varIdResource)
  }

  async getResource(idSubContenido: string) {
    try {
      this.varLoading = true
      const response: any = await this.resourceStudentService.getListResource(idSubContenido).toPromise()
      this.resource = response
      this.resource = this.addFlag(this.resource)
      console.log(this.resource)
      this.varLoading = false
    } catch (e) {
      console.log(e)
    }
  }

  addFlag(array: any[]) {
    let arrayTem = []
    for (let item of array) {
      arrayTem.push({...item, flag: false})
    }
    return arrayTem
  }

  async checkResource(item: ResourceStudentModel) {
    try {
      item.flag = true
      const response: any = await this.homeworkStudentService.getResource(item.idRecurso.toString()).toPromise()
      let data = response
      this.generateModal(data)
      item.flag = false
    } catch (e) {
      item.flag = false
      console.log(e)
    }
  }

  private generateModal(data: any) {
    const modal = this.modalService.create({
      nzTitle: 'Ayuda',
      nzContent: ModalHelpStudentComponent,
      nzWidth: 750,
      nzComponentParams: {
        resource: data
      },
      nzMaskClosable: false,
    })
  }
}
