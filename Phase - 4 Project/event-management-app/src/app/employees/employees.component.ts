import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';
import { Employee } from '../employee';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit{
  employeeRef = new FormGroup({
    id:new FormControl(),
    first_name:new FormControl(),
    last_name:new FormControl(),
    email:new FormControl()
  });
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

  viewDetails(id:any):void {
      //alert(id);
      sessionStorage.setItem("eid",id);
      this.router.navigate(["employeeview"]);
  }
  
    storeEmployee(): void {
      this.router.navigate(["addemployees"]);
}

}
