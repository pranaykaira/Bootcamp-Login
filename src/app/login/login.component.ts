import { Component, OnInit } from '@angular/core';
import { Login, LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private loginservice: LoginService,private router:Router) { }
  userEmail:string;
  userPassword:string;
  result:String;
  ngOnInit(): void {
  } 
  login(userEmail,userPassword):void{
    this.loginservice.login(this.userEmail,this.userPassword)
        .subscribe(
          data => {
            this.result=data;
            if(this.result=="Login Successful"){
              this.router.navigate(['/home']);
            }
    });
            
}
}
