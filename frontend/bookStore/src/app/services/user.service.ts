import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http:HttpClient
  ) { }


  //addEmployee
  public addEmployee(emp : any){
    return this.http.post(`${baseUrl}user/`,emp);
  }
}
