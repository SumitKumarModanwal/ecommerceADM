import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule} from '@angular/material/form-field'
import { MatInputModule} from '@angular/material/input'
import { MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card'
import { FormsModule } from '@angular/forms';
import { MatButtonModule} from '@angular/material/button';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import {MatIconModule} from '@angular/material/icon';
import { LoginService } from './services/login.service';
import { AuthGuard } from './services/auth.guard';
import { AuthInterceptor } from './services/auth.interceptor';
import { RegisterComponent } from './components/register/register.component';
import {MatRadioModule} from '@angular/material/radio';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    DashboardComponent,
    HomeComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatInputModule,
    MatFormFieldModule,
    MatCardModule,
    MatIconModule,
    MatRadioModule
  ],
  providers: [LoginService,AuthGuard,[{provide:HTTP_INTERCEPTORS,useClass:AuthInterceptor,multi:true}]],
  bootstrap: [AppComponent]
})
export class AppModule { }
