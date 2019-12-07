import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Login, PayloadDataToken, PayloadToken} from "../model/auth.model";
import * as jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private API_URL_LOGIN = `${environment.apiMain}login`
  private API_URL_LOGIN_DATA = `${environment.apiMain}usuarios/asdaaa`
  private payload: PayloadToken
  private payloadData: PayloadDataToken

  constructor(private http: HttpClient) {
  }

  postLogin(data: Login) {
    return this.http.post(this.API_URL_LOGIN, data)
  }

  getLoginData(username:string){
    return this.http.get(this.API_URL_LOGIN_DATA)
  }

  logout() {
    localStorage.removeItem('access_token');
  }

  private getTokenDecode() {
    try {
      const token = localStorage.getItem('access_token')
      return jwt_decode(token);
    }catch (e) {

    }
  }

  getUsername(){
    this.payload = this.getTokenDecode()
    return this.payload.sub.toString()
  }

  getTokenDataUsername() {
    return JSON.parse(localStorage.getItem('data_username'))
  }

  ///
  getDataUsername(){
    this.payloadData = this.getTokenDataUsername()
    return this.payloadData
  }
  // //
  // getIdStudent() {
  //   return this.payload.student.id
  // }
  //
  // getCodigoGradoStudent() {
  //   return this.payload.student.codigoGrado
  // }
  //
  // getSiglasStudent() {
  //   return this.payload.student.siglas
  // }
  //
  // getLastNameStudent() {
  //   return this.payload.student.apellidoPaterno
  // }
  //
  // getFirstNameStudent() {
  //   return this.payload.student.nombre
  // }
  //
  // getSeccionStudent() {
  //   return this.payload.student.seccion
  // }
  //
  // getAnioStudent() {
  //   return this.payload.student.anio
  // }
}
