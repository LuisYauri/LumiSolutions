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
    title: 'Criterios',
    icon: 'copy',
    url: ''
  }
  varLoading = false

  varTitleCriterio = 'Criterios'
  varTitleCotenido = 'Contenidos'

  listCriteria: Criteria[] = [
    {
      "idCriterio": 1,
      "nombre": "Figma",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/figma-desde-cero-poster.png"
    },
    {
      "idCriterio": 2,
      "nombre": "VueJS",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 3,
      "nombre": "RxJs",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/RxJs.png"
    },
    {
      "idCriterio": 4,
      "nombre": "Angular",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-08/angular.png"
    },
    {
      "idCriterio": 5,
      "nombre": "Firebase",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-07/firebase-web.png"
    },
    {
      "idCriterio": 6,
      "nombre": "Audition",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-07/AuditionDesdeCero.png"
    }, {
      "idCriterio": 7,
      "nombre": "Google Analytics",
      "urlImagen": "https://drupal.ed.team/sites/default/files/imagenes-cdn-edteam/2019-06/Google%20analytics%20Avanzado.png"
    }, {
      "idCriterio": 8,
      "nombre": "After Effects",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-07/AfterEffectsDesdeCero.png"
    }, {
      "idCriterio": 9,
      "nombre": "Redes",
      "urlImagen": "https://drupal.ed.team/sites/default/files/imagenes-cdn-edteam/2019-03/Redes%20Conmutacion.png"
    }
  ]
  listContent: Content[] = [
    {
      "idCriterio": 1,
      "idContenido": 1,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/figma-desde-cero-poster.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    },
    {
      "idCriterio": 1,
      "idContenido": 2,
      "nombre": "Criterio1",
      "urlImagen": "https://drupal.ed.team/sites/default/files/styles/16_9_medium/public/imagenes-cdn-edteam/2019-10/Vue-JS.png"
    }
  ]

  constructor(private criteriaStudentService: CriteriaStudentService,private route: ActivatedRoute,private router: Router) {
  }

  ngOnInit() {
    this.getListCriteria()
    this.listCriteria = [...this.listCriteria]
    this.varLoading = true
  }

  private getListCriteria() {
    // //Consumo de servicio
    // try {
    //   const response: any = await this.criteriaStudentService.getListCriteria().toPromise()
    //   this.listCriteria = response
    // } catch (e) {
    //   console.log(e)
    // }
  }


  getCriterio($event: Criteria) {
    console.log($event)
  }

  getContent($event: Content) {
    //this.router.navigate(['/student/criteria/content/',$event.idContenido.toString()]);
  }
}
