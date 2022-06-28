import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  url="http://localhost:9595";

  constructor(private http:HttpClient) { }

  //calling the server to generate the token
  //token generation
  generateToken(credentials:any){
    return this.http.post(`${this.url}/token`,credentials)
  }

//to login the user
  loginUser(token: string){
    localStorage.setItem("token",token);
    return true;
  }
//to check user is login or not
  isLoggedIn(){
    let token=localStorage.getItem("token");
    if(token==undefined||token===''||token==null){
      return false;
    }
    else{
      return true;
    }
  }
//to logout the user
  logoutUser(){
    localStorage.removeItem('token');
    return true;
  }
  //for getting the token
  getToken(){
    return localStorage.getItem('token')
  }
}
