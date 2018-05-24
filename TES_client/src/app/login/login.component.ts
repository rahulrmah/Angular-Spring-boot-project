import { ValidateFn } from 'codelyzer/walkerFactory/walkerFn';
//import * as console from 'console';
import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { LoginService } from '../login.service';
import {User} from '../user';

import { Router,  NavigationExtras,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   user=new User;

   userRole:String[];
  

  @ViewChild('username') el:ElementRef;
  statuslogin:any;
  focusin: boolean = true;
  rForm: FormGroup;
  post:any;  
  usernameAlert:string="Please fill username";
  passwordAlert:string="Please fill password";
  loginAlert:string = "Invalid credentials";
  loginError:boolean=false;
  returnUrl: string;  

  constructor( private LoginService:LoginService, private fb:FormBuilder, 
      private route: ActivatedRoute,   
      public router: Router ) { 
        
        this.rForm = fb.group({
      'username' : [null, Validators.required],
      'password' : [null, Validators.required],
    });
  }

  ngOnInit() {

    this.LoginService.logout();
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/index';
  }

  loginComponent(){
  this.LoginService.loginFunction(this.user).subscribe(
      res => {
        if(res.status == 200)
          {
            console.log("route to tes");
            this.router.navigate([this.returnUrl]);
          }else{
            console.log("route to tes fail");
            this.loginError = true;
            this.loginAlert = res.message;
          }
      },
       err => {
         console.log(err);
         console.log("route to tes error");
         this.loginError = true;
        return err;
          
      }
    );
   
}
}
