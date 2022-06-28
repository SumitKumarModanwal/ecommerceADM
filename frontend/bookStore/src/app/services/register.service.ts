import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/User';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private restUrl: string='http://localhost:8083/bookStore'
  constructor(private http:HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  registerUser(user:User):Observable<User>{
    return this.http.post<User>(`${this.restUrl}`,user);
 }
}
