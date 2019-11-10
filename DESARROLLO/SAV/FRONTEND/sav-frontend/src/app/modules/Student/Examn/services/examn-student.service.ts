import { Injectable } from '@angular/core';
import {environment} from "../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../services/auth.service";
import {SendAnswersExamenStudent} from "../model/examn-student.model";

@Injectable({
  providedIn: 'root'
})
export class ExamnStudentService {

  private API_URL_LIST_EXAMN = `${environment.apiMain}examenes?idEstudiante=`
  private API_URL_QUESTIONS = `${environment.apiMain}examenes/`
  private API_URL_SEND_ANSWERS_EXAMN = `${environment.apiMain}examenes/`

  constructor(private http: HttpClient, private authService: AuthService) { }

  getListExamn() {
    return this.http.get(`${this.API_URL_LIST_EXAMN}${this.authService.getIdEstudiante().toString()}`)
  }
  getQuestions(idExamn: string) {
    return this.http.get(`${this.API_URL_QUESTIONS}${idExamn}/preguntas`)
  }

  postAnswers(idExamn: string, data: SendAnswersExamenStudent) {
    return this.http.post(`${this.API_URL_SEND_ANSWERS_EXAMN}${idExamn}/estudiante/${this.authService.getIdEstudiante().toString()}/finalizar`, data)
  }
}
