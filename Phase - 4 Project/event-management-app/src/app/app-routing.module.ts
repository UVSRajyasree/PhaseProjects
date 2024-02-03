import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path:"employees",component:EmployeesComponent},
  {path:"employeeview",component:EmployeelistComponent},
  {path:"addemployees",component:AddemployeeComponent},
  {path:"login",component:LoginComponent},
  {path:"employeelogin",component:EmployeesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
