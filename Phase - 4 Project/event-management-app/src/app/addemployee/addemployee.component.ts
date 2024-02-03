import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit{
  employeeRef = new FormGroup({
    id:new FormControl(),
    first_name:new FormControl(),
    last_name:new FormControl(),
    email:new FormControl()
  });

  submitButton:string ="Add Employee";
  employees:Array<Employee>=[];
  constructor(public es:EmployeeService,
    public router:Router){}  //DI

  ngOnInit(): void {
    this.loadEmployee()  
  }

  loadEmployee() : void {
    this.es.findAllEmployee().subscribe({
      next:(data:any)=>this.employees=data,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("All Employee loaded")
    })
  }
  
  msg:string ="";
    storeEmployee(): void {
      let employee = this.employeeRef.value;
  
  if(this.submitButton=="Add Employee"){
  
  
    console.log(employee);
    let result = this.employees.find(e=>e.id==employee.id); // if present it return that record 
                          // else it return undefined. 
    if(result==undefined){
      this.es.storeEmployee(employee).subscribe({
        next:(data:any)=>console.log(data),
        error:(error:any)=>console.log(error),
        complete:()=>{this.loadEmployee()}
      })
    }else {
      this.msg="Employee is must be unique";
    }
    this.submitButton="Add Employee";
  }
  this.employeeRef.reset();
}
}
