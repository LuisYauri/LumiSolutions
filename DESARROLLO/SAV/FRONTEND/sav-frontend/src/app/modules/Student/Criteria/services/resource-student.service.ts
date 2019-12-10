import { Injectable } from '@angular/core';
import {environment} from "../../../../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ResourceStudentService {

  private API_URL_LIST_RESOURCE = `${environment.apiMain}recursos?idSubContenido=`

  constructor(private http: HttpClient) { }

  getListResource(idSubContenido: string) {
    return this.http.get(`${this.API_URL_LIST_RESOURCE}${idSubContenido}`)
  }
}
