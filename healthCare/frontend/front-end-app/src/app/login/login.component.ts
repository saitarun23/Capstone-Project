import { Component } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginRef=new FormGroup({
    email:new FormControl(),
    password: new FormControl(),
    type: new FormControl()
  });

  msg:string="";

  constructor(public ls:LoginService,public router:Router){}

  signin():void{
    let loginData=this.loginRef.value;

    if (loginData.type === 'admin') {
      this.ls.adminSignIn(loginData).subscribe({
        next: (result: any) => {
          if (result.status === 200) {
            this.msg = "Login Done Successfully";
            this.router.navigate(['adminDashboard']);
          }
        },
        error: () => {
          this.msg = "Invalid details";
        },
        complete: () => console.log("Admin login process complete")
      });
    } else if (loginData.type === 'user') {
      this.ls.userSignIn(loginData).subscribe({
        next: (result: any) => {
          if (result.status === 200) {
            this.msg = "Login Done Successfully";
            this.router.navigate([`userDashboard/${loginData.email}`]);
          }
        },
        error: () => {
          this.msg = "Invalid details";
        },
        complete: () => console.log("User login process complete")
      });
    }
    this.loginRef.reset();

  }

  
}
