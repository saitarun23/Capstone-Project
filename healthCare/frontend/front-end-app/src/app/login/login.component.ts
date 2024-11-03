import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { Login } from '../login';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  message: string = '';

  constructor(public fb: FormBuilder, public ls:LoginService,  public router: Router) {
    // Initialize the form with FormBuilder
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      typeofuser: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.checkCredential();
  }

  checkCredential(): void {
    if (this.loginForm.valid) {
      let loginField: Login = this.loginForm.value;

      if (loginField.typeofuser === "admin") {
          this.ls.adminSignIn(loginField).subscribe({
            next:(result:any)=>{
              this.message=result;
              
              this.router.navigate(["adminDashboard"],{skipLocationChange:true});
            },
            error:(error:any)=>{
              console.log(error);
            },
            complete:()=>console.log("signin done")
          })
      }else if(loginField.typeofuser==="user"){
        this.ls.userSignIn(loginField).subscribe({
          next:(result:any)=>{
            this.message=result;
            this.router.navigate(["userDashboard/:email"],{skipLocationChange:true});
          },
          error:(error:any)=>{
            console.log(error);
          },
          complete:()=>console.log("signin done")
        })
      }else{
        this.message="Please fill all fields correctly.";
      }
   }
   }
}