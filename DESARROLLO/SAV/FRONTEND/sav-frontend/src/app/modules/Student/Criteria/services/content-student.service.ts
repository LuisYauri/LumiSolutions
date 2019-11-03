import {Injectable} from '@angular/core';
import {environment} from "../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class ContentStudentService {
  private API_URL_SUB_CONTENT = `${environment.apiMain}subcontenidos?idContenido=`

  private static headersList() {
    return {
      headers: {
        Authorization: 'Bearer ' + localStorage.getItem('access_token')
      }
    };
  }

  constructor(private http: HttpClient,private  authService:AuthService) {
  }

  getSubContent(idContenido: string) {
    return this.http.get(`${this.API_URL_SUB_CONTENT}${idContenido}`, ContentStudentService.headersList())
  }
}
