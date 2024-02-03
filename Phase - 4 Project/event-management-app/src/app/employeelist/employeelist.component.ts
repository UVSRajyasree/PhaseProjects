import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { FormControl, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit{
  employeeRef = new FormGroup({
    id:new FormControl(),
    first_name:new FormControl(),
    last_name:new FormControl(),
    email:new FormControl()
  });

  submitButton:string ="Update Employee";
  employee:any;
f1:boolean = true;
f2:boolean = false;
 
  employees:Array<Employee>=[];
  constructor(public es:EmployeeService,public router:Router){} // DI
  
  ngOnInit(): void {
      let obj = sessionStorage.getItem("eid");
      if(obj!=null){
        let id = obj;
          this.es.findEmployeeById(id).subscribe({
            next:(data:any)=>this.employee=data,
            error:(error:any)=>console.log(error),
            complete:()=>console.log("done")
          })
      }
  }

  loadEmployee() : void {
    this.es.findAllEmployee().subscribe({
      next:(data:any)=>this.employees=data,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("All Employee loaded")
    })
  }

  displayAllEmployeeList() : void {
      this.router.navigate(["employees"])
  }

  deleteEmployee(id:any): void {
    //alert(id)
    this.es.deleteEmployee(id).subscribe({
      next:(data:any)=>console.log(data),
      error:(error:any)=>console.log(error),
      complete:()=>{this.loadEmployee()}
    })
  }

  msg:string ="";
  updateEmployee(employee:any): void {
      this.f2=true;
      this.f1=false;
      this.employeeRef.get("id")?.setValue(employee.id);    
      this.employeeRef.get("first_name")?.setValue(employee.first_name);   
      this.employeeRef.get("last_name")?.setValue(employee.last_name);   
      this.employeeRef.get("email")?.setValue(employee.email);   
      this.submitButton="Update Employee";
  }
  
}