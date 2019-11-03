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
    title: 'Criterios',
    icon: 'copy',
    url: '/student/criteria/'
  }

  varTitleSubcontent = "Temas"

  varLoading = false
  varIdContent = ""

  subContent:SubContent = {
    "nombre": "Contenido",
    "lsSubContenidos": [
      {
        "idSubContenido": 1,
        "nombre": "ga",
        "descripcion": "Criterio1",
        "urlImagen": "http://dfdsf.png"
      },
      {
        "idSubContenido": 2,
        "nombre": "sdsfs",
        "descripcion": "Criterio1",
        "urlImagen": "http://dfdsf.png"
      },
      {
        "idSubContenido": 3,
        "nombre": "dsfds",
        "descripcion": "Criterio1",
        "urlImagen": "http://dfdsf.png"
      }
    ]
  }

  constructor(private route: ActivatedRoute, private contentStudentService:ContentStudentService) { }

  ngOnInit() {
    this.varIdContent = this.route.snapshot.paramMap.get('id').toString()
    this.getSubContent(this.varIdContent)
  }

  private async getSubContent(idContent:string) {
    // Consumeo de servicio
    // try {
    //   const response:any = await this.contentStudentService.getSubContent(idContent).toPromise()
    //   this.subContent = response
    // }catch (e) {
    //   console.log(e)
    // }
  }
}
