import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl:string ="http://localhost:9090/login";
  
  constructor(public http:HttpClient) { } // DI for HttpClient reference

  signIn(login:any): Observable<string> {
    return this.http.post(this.baseUrl+"/signin",login,{responseType:'text'});
  }
  
}