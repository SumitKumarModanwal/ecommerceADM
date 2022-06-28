import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private userService:UserService) { }

  user:any
  ngOnInit(): void {
  }
  getUsers(){
     this.userService.getUser().subscribe(
      user=>{
        console.log(user);
        this.user=user;
      },
      error=>{
        console.log(error);
        
      }
     )
  }

}
