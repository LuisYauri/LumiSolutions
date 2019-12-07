import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const re = 'login';

    if (req.url.search(re) === -1 ) {
      req = req.clone({
        setHeaders: {
          Authorization: `Bearer ${localStorage.getItem('access_token')}`
        }
      });
    }
    return next.handle(req);
  }
}
