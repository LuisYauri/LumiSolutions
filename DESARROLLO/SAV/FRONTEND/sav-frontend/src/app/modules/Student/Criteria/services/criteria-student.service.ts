import { Injectable } from '@angular/core';
import {environment} from "../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class CriteriaStudentService {

  private API_URL_LIST_CRITERIA = `${environment.apiMain}criterios/`
  private API_URL_LIST_CONTENT = `${environment.apiMain}contenidos?idCriterio=`

  constructor(private http: HttpClient,private authService: AuthService) {
  }

  getListCriteria() {
    return this.http.get(`${this.API_URL_LIST_CRITERIA}`)
  }

  getListContent(idCriterio:string) {
    return this.http.get(`${this.API_URL_LIST_CONTENT}${idCriterio}&codigoGrado=${this.authService.getDataUsername().codigoGrado.toString()}`)
  }

  getListContentTeacher(idCriterio:string) {
    return this.http.get(`${this.API_URL_LIST_CONTENT}${idCriterio}&codigoGrado=${this.authService.getAula().codigoGrado.toString()}`)
  }
}
