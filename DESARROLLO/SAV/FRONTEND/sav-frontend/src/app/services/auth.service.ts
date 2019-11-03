import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Login} from "../model/auth.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private API_URL_LOGIN = `${environment.apiMain}autentificacion/login`

  constructor(private http: HttpClient) { }

  postLogin(data:Login){
    return this.http.post(this.API_URL_LOGIN,data)
  }

  logout(){
    localStorage.removeItem('access_token');
  }
}
