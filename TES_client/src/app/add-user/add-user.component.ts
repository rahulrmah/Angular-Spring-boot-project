import { Component, OnInit } from '@angular/core';
import {User} from '.././user';
import { ValidateFn } from 'codelyzer/walkerFactory/walkerFn';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { AddUserService } from '.././add-user.service';
import { UserRole } from '../userRole';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user=new User;
  tech1:string;
  status:User;
  rolevalue:string;
  userrole:string;
  selectedRoles:UserRole;
 
   tech: string[] = [
      'Java',
      'DotNet',
      'FET',
    ]

     uRole: string[] = [
      'Trainer',
      'SME',
      'Training',
      'Mentor',
      'Evaluator',
    ]
  constructor(private AddUserService:AddUserService, private fb:FormBuilder, 
      ) { }

  ngOnInit() {
    
  }

addUser(){
  if(this.user.userName&&this.user.technology&&this.user.userRoles){

     	
    if(confirm("Do you want to add user?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
     {
           
      console.log("in component  =="+this.user);
      this.AddUserService.create(this.user)
      .then(status => {
        this.status = status;
        if(this.status!=null){
         this.user=new User();
          alert("User added successfully");
        }
        else{
       
           alert("Failed to add user");
        }
        console.log('-----------');
        console.log(this.status);
          
      });


       }else{
       return false;
    }
  }else{
      alert("Please fill required fields");
  }
  }

   onSelectTech(tech11:string): void{
        this.tech1=tech11;
          console.log(this.tech1);
      }


    onSelectRole(roles:string): void {
      
    this.userrole=roles;
    console.log(this.userrole);

  }


}