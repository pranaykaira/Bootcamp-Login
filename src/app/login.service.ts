import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }
  users:Login;
  public login(userEmail:string,userPassword:string){
    console.log(userEmail,userPassword);
      return this.http.get<String>("http://localhost:4290/login/checkdetails/"+userEmail+"/"+userPassword,{responseType:'text' as 'json'});
  }

}
export class Login {
  userEmail :string;
  userPassword:string;
  constructor(email :string,password:string) {
    this.userEmail=email;
    this.userPassword=password;
  }
}
