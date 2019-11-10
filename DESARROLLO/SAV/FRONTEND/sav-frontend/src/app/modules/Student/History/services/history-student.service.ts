import { Injectable } from '@angular/core';
import {environment} from "../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class HistoryStudentService {

  private API_URL_LIST_HISTORY = `${environment.apiMain}historiales?idEstudiante=`
  private API_URL_RESULTS_STATICS = `${environment.apiMain}historiales/estadisticas?idEstudiante=`
  private API_URL_RESULTS_STATICS_QUESTIONS = `${environment.apiMain}historiales/preguntas?idEstudiante=`

  constructor(private http: HttpClient, private authService: AuthService) { }

  getListHistory() {
    return this.http.get(`${this.API_URL_LIST_HISTORY}${this.authService.getIdEstudiante().toString()}`)
  }

  getResultsStatics(idEvaluacion:string){
    return this.http.get(`${this.API_URL_RESULTS_STATICS}${this.authService.getIdEstudiante().toString()}&idEvaluacion=${idEvaluacion}`)
  }

  getResultsStaticsQuestions(idEvaluacion:string){
    return this.http.get(`${this.API_URL_RESULTS_STATICS_QUESTIONS}${this.authService.getIdEstudiante().toString()}&idEvaluacion=${idEvaluacion}`)
  }
}
