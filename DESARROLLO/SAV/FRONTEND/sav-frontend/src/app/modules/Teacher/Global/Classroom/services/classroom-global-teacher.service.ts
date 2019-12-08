import { Injectable } from '@angular/core';
import {environment} from "../../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class ClassroomGlobalTeacherService {

  private API_URL_LIST_CLASSROOM = `${environment.apiMain}aulas`

  constructor(private http: HttpClient) { }

  getListClassroom(){
    return this.http.get(`${this.API_URL_LIST_CLASSROOM}`)
  }
}
