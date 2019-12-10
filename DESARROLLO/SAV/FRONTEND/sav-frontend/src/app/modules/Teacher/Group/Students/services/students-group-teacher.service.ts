import {Injectable} from '@angular/core';
import {environment} from "../../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class StudentsGroupTeacherService {

  private API_URL_LIST_STUDENTS = `${environment.apiMain}estudiantes/`
  private API_URL_DELETE_STUDENTS = `${environment.apiMain}matricula/`

  constructor(private http: HttpClient, private authService: AuthService) {
  }

  getListStudents() {
    return this.http.get(`${this.API_URL_LIST_STUDENTS}${this.authService.getAula().idAula.toString()}`)
  }

  deleteStudents(idStudents: string) {
    return this.http.delete(`${this.API_URL_DELETE_STUDENTS}${idStudents}/${this.authService.getAula().idAula.toString()}`)
  }
}
