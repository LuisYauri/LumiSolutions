import {Injectable} from '@angular/core';
import {environment} from "../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../services/auth.service";
import {Answer, SendAnswers} from "../model/homework-student.model";

@Injectable({
  providedIn: 'root'
})
export class HomeworkStudentService {

  private API_URL_LIST_HOMEWORK = `${environment.apiMain}tareas?idEstudiante=`
  private API_URL_QUESTIONS = `${environment.apiMain}tareas/`
  private API_URL_SEND_ANSWERS = `${environment.apiMain}tareas/`
  private API_URL_CHECK_ANSWER = `${environment.apiMain}preguntas/`
  private API_URL_RESOURCE = `${environment.apiMain}recursos/`

  constructor(private http: HttpClient, private authService: AuthService) {
  }

  getListHomework() {
    return this.http.get(`${this.API_URL_LIST_HOMEWORK}${this.authService.getIdStudent().toString()}`)
  }

  getQuestions(idTarea: string) {
    return this.http.get(`${this.API_URL_QUESTIONS}${idTarea}/preguntas`)
  }

  postAnswers(idTarea: string, data: SendAnswers) {
    return this.http.post(`${this.API_URL_SEND_ANSWERS}${idTarea}/estudiante/${this.authService.getIdStudent().toString()}/finalizar`, data)
  }

  postCheckAnswer(idPregunta: string, data: Answer) {
    return this.http.post(`${this.API_URL_CHECK_ANSWER}${idPregunta}/comprobar`, data)
  }

  getResource(idRecurso:string){
    return this.http.get(`${this.API_URL_RESOURCE}${idRecurso}/estudiante/${this.authService.getIdStudent().toString()}`)
  }
}
