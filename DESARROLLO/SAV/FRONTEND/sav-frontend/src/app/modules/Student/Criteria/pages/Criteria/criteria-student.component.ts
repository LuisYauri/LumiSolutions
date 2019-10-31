import {Component, OnInit} from '@angular/core';
import {Criteria} from "../../model/criteria.model";
import {CriteriaStudentService} from "../../services/criteria-student.service";

@Component({
  selector: 'app-criteria-student',
  templateUrl: './criteria-student.component.html',
  styleUrls: ['./criteria-student.component.scss']
})
export class CriteriaStudentComponent implements OnInit {

  varHeader = {
    title: 'Criterios',
    icon: 'copy',
    url: ''
  }

  varTitle = 'Lista de criterios'

  listCriteria: Criteria[] = [
    {
      "idCriterio": 1,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/figma-desde-cero-poster.png"
    },
    {
      "idCriterio": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 3,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/RxJs.png"
    },
    {
      "idCriterio": 4,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-08/angular.png"
    },
    {
      "idCriterio": 5,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-07/firebase-web.png"
    },
    {
      "idCriterio": 6,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-07/AuditionDesdeCero.png"
    }, {
      "idCriterio": 7,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/imagenes-cdn-edteam/2019-06/Google%20analytics%20Avanzado.png"
    }, {
      "idCriterio": 8,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-07/AfterEffectsDesdeCero.png"
    }, {
      "idCriterio": 9,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/imagenes-cdn-edteam/2019-03/Redes%20Conmutacion.png"
    }
  ]

  constructor(private criteriaStudentService: CriteriaStudentService) {
  }

  ngOnInit() {
    this.getListCriteria()
  }

  private async getListCriteria() {
    // //Consumo de servicio
    // try {
    //   const response: any = await this.criteriaStudentService.getListCriteria().toPromise()
    //   this.listCriteria = response
    // } catch (e) {
    //   console.log(e)
    // }
  }

}
