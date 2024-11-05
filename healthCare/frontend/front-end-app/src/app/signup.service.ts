import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  baseUrl :string="http://localhost:9090/login";

  constructor(public http:HttpClient) { }

  signUp(user:any): Observable<string> {
    return this.http.post(`${this.baseUrl}/signup`,user,{responseType:'text'});
  }

}
