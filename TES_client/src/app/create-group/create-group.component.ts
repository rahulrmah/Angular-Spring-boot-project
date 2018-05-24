import { Component, OnInit } from '@angular/core';
import { CreateGroupService } from '.././create-group.service';
import { FormBuilder } from '@angular/forms';
@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.css']
})
export class CreateGroupComponent implements OnInit {

  javaMentees:any;
  dotNetMentees:any;
  fetMentees:any;
  mentorUsers:any;
  technology:String="";
  groupName:String="";
  javaMenteeOptions:boolean;
  dotNetMenteeOptions:boolean;
  fetMenteeOptions:boolean;
  mentee1:number=0;
  mentee2:number=0;
  mentee3:number=0;
  mentee4:number=0;
  mentees:number[]=[];

  constructor(private createGroupService:CreateGroupService,private fb:FormBuilder) { }

  ngOnInit() {
    this.javaMenteeOptions=false;
    this.dotNetMenteeOptions=false;
    this.fetMenteeOptions=false;
   
  }
  getJavaMentees(){
    this.createGroupService.getJavaMentees();
  }
  getDotNetMentees(){
    this.createGroupService.getDotNetMentees();
  }
  getFETMentees(){
    this.createGroupService.getFETMentees();
  }

  onSelectTech(technology:String){
    this.mentee1=0;
    this.mentee2=0;
    this.mentee3=0;
    this.mentee4=0;
    this.technology=technology;
    if(this.technology==="Java"){
      this.getJavaMentees();
      this.javaMentees =JSON.parse(sessionStorage.getItem('javaMentees'));
      this.javaMenteeOptions=true;
      this.dotNetMenteeOptions=false;
      this.fetMenteeOptions=false;
    }
    else if(this.technology==="DotNet"){
      this.getDotNetMentees();
      this.dotNetMentees =JSON.parse(sessionStorage.getItem('dotNetMentees'));
      this.javaMenteeOptions=false;
      this.dotNetMenteeOptions=true;
      this.fetMenteeOptions=false;
    }
    else if(this.technology==="FET"){
      this.getFETMentees();
      this.fetMentees =JSON.parse(sessionStorage.getItem('fetMentees'));
      this.javaMenteeOptions=false;
      this.dotNetMenteeOptions=false;
      this.fetMenteeOptions=true;
    }
    else{
      this.javaMenteeOptions=false;
      this.dotNetMenteeOptions=false;
      this.fetMenteeOptions=false;
    }
  }

  createGroup(){
   
     if(this.mentee1 != 0)
      this.mentees.push(this.mentee1);
    if(this.mentee2 != 0)
      this.mentees.push(this.mentee2);
    if(this.mentee3 != 0)
      this.mentees.push(this.mentee3);
    if(this.mentee4 != 0)
      this.mentees.push(this.mentee4);
 if((this.mentee1 != 0||this.mentee2 != 0||this.mentee3 != 0||this.mentee4 != 0)&&this.groupName)
   {
    if(confirm("Do you want to create Group ?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
   {
    this.createGroupService.createGroup(this.mentees,this.groupName)
     .then(status => {
       
        if(status!=null){
         
            alert("Group Created successfully");
        }
        else{
          
            alert( "Failed to create group");
        }
       
          
      });
    this.mentee1=0;
    this.mentee2=0;
    this.mentee3=0;
    this.mentee4=0;
    this.groupName="";
 
  }else{
       return false;
    }
   }else{
      alert( "Please fill all fields");
   }
  }

  
}
