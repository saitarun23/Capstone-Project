import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
 
  adminUrl: string="http://localhost:9090/admin/login";
  userUrl:string="http://localhost:9090/user/login";

  constructor(public http:HttpClient) { } // DI for HttpClient reference. 

  adminSignIn(login:any):Observable<string>{
    return this.http.post(this.adminUrl,login,{responseType:'text'});
  }

  userSignIn(login:any):Observable<string>{
    return this.http.post(this.userUrl,login,{responseType:'text'});
  }
}
