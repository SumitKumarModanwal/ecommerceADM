import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/pages/login/login.component';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public isLoggedIn=false;
  public user = null;


  constructor(public login:LoginService) { }

  ngOnInit(): void {
    this.isLoggedIn=this.login.isLoggedIn();
    console.log(this.isLoggedIn)
    this.user = this.login.getUser();
  }

  public logout(){
    this.login.logout();
    this.isLoggedIn=false;
    this.user=null;
    location.reload();
  }
}
