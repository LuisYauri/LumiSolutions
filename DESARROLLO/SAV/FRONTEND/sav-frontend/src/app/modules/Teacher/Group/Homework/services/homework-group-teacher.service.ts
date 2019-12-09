import {Injectable} from '@angular/core';
import {environment} from "../../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class HomeworkGroupTeacherService {

  private API_URL_LIST_QUESTIONS = `${environment.apiMain}preguntas?grado=`
  private API_URL_POST_HOMEWORK = `${environment.apiMain}profesor/tareas/`
  private API_URL_LIST_HOMEWORK = `${environment.apiMain}profesor/tareas?idAula=`
  private API_URL_DELETE_HOMEWORK = `${environment.apiMain}profesor/tareas/`
  private API_URL_VIEW_QUESTIONS = `${environment.apiMain}preguntas/`

  constructor(private http: HttpClient, private authService: AuthService) {
  }

  getListQuestions(idCriterio: string, idContenido: string) {
    return this.http.get(`${this.API_URL_LIST_QUESTIONS}${this.authService.getAula().codigoGrado.toString()}&idCriterio=${idCriterio}&idContenido=${idContenido}`)
  }

  postHomework(data: any) {
    return this.http.post(`${this.API_URL_POST_HOMEWORK}`, data)
  }

  getListHomework() {
    return this.http.get(`${this.API_URL_LIST_HOMEWORK}${this.authService.getAula().idAula.toString()}`)
  }

  deleteHomework(idTarea: string) {
    return this.http.patch(`${this.API_URL_DELETE_HOMEWORK}${idTarea}`, '')
  }

  getViewQuestion(idPregunta: string) {
    return this.http.get(`${this.API_URL_VIEW_QUESTIONS}${idPregunta}`)
  }
}
