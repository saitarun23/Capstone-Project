import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';

const routes: Routes = [
  { path: '', component: LoginComponent }, 
  {path:"login",redirectTo:"",pathMatch:"full"},
  { path: 'adminDashboard', component: AdmindashboardComponent },
  { path: 'userDashboard/:email', component: UserdashboardComponent },
  { path: '**', redirectTo: '' } 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
