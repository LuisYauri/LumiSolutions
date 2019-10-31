import {Injectable} from '@angular/core';
import {environment} from "../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CriteriaStudentService {

  private API_URL_LIST_CRITERIA = `${environment.apiMain}criterios/`

  private headersList() {
    return {
      headers: {
        Authorization: 'Bearer ' + localStorage.getItem('access_token')
      }
    };

  }

  constructor(private http: HttpClient) {
  }

  getListCriteria() {
    return this.http.get(this.API_URL_LIST_CRITERIA, this.headersList())
  }
}
