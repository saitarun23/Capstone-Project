import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:"signin",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"admin",component:AdmindashboardComponent},
  {path:"user",component:UserdashboardComponent},
  {path:"login",redirectTo:"/",pathMatch:'full'}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }