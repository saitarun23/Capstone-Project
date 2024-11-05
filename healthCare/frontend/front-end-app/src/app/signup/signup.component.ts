import { Component } from '@angular/core';
import { SignupService } from '../signup.service';
import { FormControl, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  signUpRef=new FormGroup({
    email:new FormControl(),
    firstname:new FormControl(),
    lastname:new FormControl(),
    password:new FormControl(),
    dob:new FormControl(),
    phonenumber:new FormControl(),
    address:new FormControl()
  })

  msg:string="";
  
  constructor(public su:SignupService){}

  signUp():void{

    let user=this.signUpRef.value;
    console.log(user);

      this.su.signUp(user).subscribe({
      next:(result:any)=>{
        this.msg=result;
      
      },
      error:(error:any)=> {
        console.log(error);
    },
    complete:()=>console.log("signup done!")
    });
    this.signUpRef.reset();
  }
  
}
