import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Login, PayloadToken} from "../model/auth.model";
import * as jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private API_URL_LOGIN = `${environment.apiMain}autentificacion/login`
  private payload:PayloadToken

  constructor(private http: HttpClient) { }

  postLogin(data:Login){
    return this.http.post(this.API_URL_LOGIN,data)
  }

  logout(){
    localStorage.removeItem('access_token');
  }

  private getTokenDecode(){
    const token = localStorage.getItem('access_token')
    return jwt_decode(token);
  }

  getToken(){
    return localStorage.getItem('access_token')
  }

  getIdEstudiante(){
    this.payload = this.getTokenDecode()
    return this.payload.identity.idEstudiante
  }

  getCodigoGrado(){
    this.payload = this.getTokenDecode()
    return this.payload.identity.codigoGrado
  }

  getSiglas(){
    this.payload = this.getTokenDecode()
    return this.payload.identity.siglas
  }
}
