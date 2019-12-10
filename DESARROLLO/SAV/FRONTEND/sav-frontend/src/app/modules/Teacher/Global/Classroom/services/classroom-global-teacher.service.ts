import {Injectable} from '@angular/core';
import {environment} from "../../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class ClassroomGlobalTeacherService {

  private API_URL_LIST_CLASSROOM = `${environment.apiMain}aulas`
  private API_URL_POST_CLASSROOM = `${environment.apiMain}aulas/`
  private API_URL_DELETE_CLASSROOM = `${environment.apiMain}aulas/`

  constructor(private http: HttpClient) {
  }

  getListClassroom() {
    return this.http.get(this.API_URL_LIST_CLASSROOM)
  }

  postClassroom(data: any) {
    return this.http.post(this.API_URL_POST_CLASSROOM, data)
  }

  putClassroom(data: any) {
    return this.http.put(this.API_URL_POST_CLASSROOM, data)
  }

  deleteClassroom(id:string){
    return this.http.patch(`${this.API_URL_DELETE_CLASSROOM}${id}`,'')
  }
}
