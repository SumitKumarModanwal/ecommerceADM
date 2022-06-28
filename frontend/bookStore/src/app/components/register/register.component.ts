import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/services/register.service';
import { User } from 'src/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  credentials:User={
     firstname:'',
     lastname:'',
     email:'',
     password:'',
     address:'',
     phonenumber:0

  }
  submitted=false;
  constructor(private router:Router, private restApi:RegisterService) { }

  ngOnInit(): void {
  }
  addUser(){
    console.log(this.credentials);
    
    
      this.restApi.registerUser(this.credentials).subscribe(
        data=> {
          alert("User successfully registered")
          this.router.navigate(['/login'])
        },
        error=>{
          alert("User not registered")
        }
      );

    
    
  }
  // onSubmit(){
  //   if((this.credentials.firstname!=''&&this.credentials.lastname!=''&&this.credentials.address!=''&&this.credentials.password!=''&&this.credentials.email!=''&&this.credentials.phonenumber!=null)&&(this.credentials.firstname!=null&&this.credentials.lastname!=null&&this.credentials.address!=null&&this.credentials.password!=null&&this.credentials.email!=null&&this.credentials.phonenumber!=null)){
  //     alert('User registered successfully :) ');
  //   }else{
  //     alert('Please enter details');
  // }
  // }
  

}
