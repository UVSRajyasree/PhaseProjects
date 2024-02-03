import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Login } from '../login';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  msg:string ="";
  loginRef = new FormGroup({
    emailid:new FormControl(),
    password:new FormControl()
  });
  submitButton:string ="Update Password";
  login:any;
logins:Array<Login>=[];
  constructor(public router:Router, public ls:LoginService){}   // DI for Router API which help to navigate to another component 
  
  // this method called only once when component loaded....
ngOnInit(): void {
      this.ls.loadAllUsers().subscribe({
        next:(data:any)=>this.logins=data,
        error:(error:any)=>console.log(error),
        complete:()=>console.log("all login details loaded...")
      })
  }
  
  signIn(): void {
    let login = this.loginRef.value;

    let result = this.logins.find(l=>l.emailid==login.emailid && l.password==login.password); 
    // if present it return that record else it return undefined 

    // if(login.emailid=="akash@gmail.com" && login.password=="123"){
    //     this.router.navigate(["home"]);
    // }else {
    //     this.msg="Error try once again";
    // }

    if(result!=undefined){
      this.router.navigate(["employeelogin"], {skipLocationChange: true});
    }else {
      this.msg="Error try once again";
    }

    this.loginRef.reset();
  }

  
  updatePassword(login:any): void {
      this.loginRef.get("emailid")?.setValue(login.emailid);    
      this.loginRef.get("password")?.setValue(login.password);     
      this.submitButton="Update Password";
  }
}
