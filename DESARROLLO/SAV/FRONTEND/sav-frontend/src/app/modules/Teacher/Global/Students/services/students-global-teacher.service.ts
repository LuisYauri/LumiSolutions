import {Injectable} from '@angular/core';
import {environment} from "../../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class StudentsGlobalTeacherService {

  private API_URL_LIST_STUDENTS = `${environment.apiMain}estudiantes`
  private API_URL_POST_STUDENTS = `${environment.apiMain}estudiantes/`
  private API_URL_DELETE_STUDENTS = `${environment.apiMain}estudiantes/`

  constructor(private http: HttpClient) {
  }

  getListStudents() {
    return this.http.get(this.API_URL_LIST_STUDENTS)
  }

  postStudents(data: any) {
    return this.http.post(this.API_URL_POST_STUDENTS, data)
  }

  putStudents(data: any) {
    return this.http.put(this.API_URL_POST_STUDENTS, data)
  }

  deleteStudents(id: string) {
    return this.http.patch(`${this.API_URL_DELETE_STUDENTS}${id}`, '')
  }
}
