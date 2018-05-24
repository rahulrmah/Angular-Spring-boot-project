import { AssignMentorEvaluatorService } from '../assign-mentor-evaluator.service';
import { Component, OnInit } from '@angular/core';
import {User} from '.././user';
import {Mentee} from '.././mentees';
import { ValidateFn } from 'codelyzer/walkerFactory/walkerFn';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { AddUserService } from '.././add-user.service';
import { UserRole } from '../userRole';
import 'rxjs/add/operator/map';
@Component({
  selector: 'app-assign-mentor-evaluator',
  templateUrl: './assign-mentor-evaluator.component.html',
  styleUrls: ['./assign-mentor-evaluator.component.css']
})
export class AssignMentorEvaluatorComponent implements OnInit {
userRoles=new UserRole;
  mentee = new Mentee;
   mentorArray:any[]=[];
   evaluatorArray:any[]=[];
  userObj:any[]=[];
  evaluatorObj:any;
  mentorObj:any;
  groupObj:any[]=[];
  menteesNameArray:any[];
  menteesNameGrp:String[]=[];
  userType:string;
  mentEvalPresentStatus:string="";
 tech: string[] = [
      'Java',
      'DotNet',
      'FET',
    ]

    uRole: string[] = [
      'Mentor',
      'Evaluator'
      ]
 tech1:string;
 mentorId:number=0;
 userId:number=0;
  groupId:number=0;
  constructor(private AssignMentorEvaluatorService:AssignMentorEvaluatorService, private fb:FormBuilder ) { }

  ngOnInit() {
   this.mentEvalPresentStatus="";
  }

    assignMentorEvaluator(){
   if(this.userId&&this.groupId&&this.userRoles.role){

       if(confirm("Do you want to assign ?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
     {
      
         this.AssignMentorEvaluatorService.assignUser(this.userId,this.groupId,this.userRoles.role).subscribe(
      res => {
        if(res.status == 200)
          {
            console.log(res);
           
               alert("Assigned Successfully");
            this.menteesNameGrp=[];
            this.userRoles=new UserRole();
            this.mentee=new Mentee();
            this.userObj=[];
            this.groupObj=[];
        
            this.userType="";
          }else{
            console.log("route to tes assign");
           
             alert("Failed to assign");
            console.log(res);
          }
      },
       err => {
         console.log(err);
         console.log("route to adduser error");
          alert("Failed to assign");
        return err;
          
      }
    );

    }else{
       return false;
    }

   }else{
      alert("Please fill all fields");
   }
  }






  onSelectUser(uid:number){
    console.log("user id =="+this.userId);
  }



  selectUserType(usertype:string){
    console.log("selectUserType==="+usertype);

    console.log("===="+this.userRoles.role)
    this.userType=usertype;
    this.userObj=[];
    this.AssignMentorEvaluatorService.getrollwiseUser(this.userRoles,this.mentee.technology).subscribe(
      res => {
        if(res.status == 200)
          {
            console.log(res);
              
            console.log("get result");


          var rolewiseUser =JSON.parse(localStorage.getItem('roleDetails'));
            console.log(rolewiseUser);
            

            rolewiseUser.map(user => {
                this.userObj.push(user);
              console.log("got rolewise user ==="+user.userName);
        
            });


           
             
          }else{
            console.log("route to tes aduser");
            
            console.log(res);
          }
      },
       err => {
         console.log(err);
         console.log("route to adduser error");
        return err;
          
      }
    );


  }






  onSelectGroup(grpName:string): void{
     console.log("group id==="+this.groupId);
    console.log(" in onSelectGroup");
     this.mentEvalPresentStatus="";
     this.mentorObj="";
     this.evaluatorObj=[];

      this.mentorArray=[];
   this.evaluatorArray=[];

      var currentGroups =JSON.parse(localStorage.getItem('GroupsDetail'));
     console.log(currentGroups);
      this.menteesNameGrp = [];

    currentGroups.map(group => {
     
    if(group.groupId==this.groupId){

 
      group.mentees.map(mentee=>{

        console.log("each grp =="+mentee.menteeName);
         this.menteesNameGrp.push(mentee.menteeName); 
      });
       
      group.mentors.map(mentor=>{
        
        console.log(mentor);
        this.mentorObj=mentor;

        
      });

      group.evaluators.map(evaluator=>{
        
        console.log(evaluator);
        this.evaluatorObj=evaluator;

        });

        if(this.mentorObj&&this.evaluatorObj){
            console.log("mentor asign");
            console.log(this.groupId);
            console.log("mentor asign");

          
            this.AssignMentorEvaluatorService.getEvaluator(this.groupId).subscribe(
      res => {
        if(res.status == 200)
          {
            console.log(res);
              
            console.log("route to adduset");
            var evlTemp =JSON.parse(localStorage.getItem('EvlData'));
           console.log(this.mentorArray);

                evlTemp.map(evl=>{
                  this.evaluatorArray.push(evl.userName);
                   console.log(evl.userName);
                }

                );
          
             
          }else{
            console.log("route to tes aduser");
            
            console.log(res);
          }
      },
       err => {
         console.log(err);
         console.log("route to adduser error");
        return err;
          
      }
    );




            this.AssignMentorEvaluatorService.getMentor(this.groupId).subscribe(
      res => {
        if(res.status == 200)
          {
            console.log(res);
              
            console.log("route to adduset");
           

        var mentorTemp =JSON.parse(localStorage.getItem('mentorData'));
           console.log(this.mentorArray);

                mentorTemp.map(mentor=>{
                  this.mentorArray.push(mentor.userName);
                   console.log(mentor.userName);
                }

                );
             
          }else{
            console.log("route to tes aduser");
            
            console.log(res);
          }
      },
       err => {
         console.log(err);
         console.log("route to adduser error");
        return err;
          
      }
    );



       // this.mentEvalPresentStatus="Mentor and Evalutor is already assigned to this group";
           
        }else{

          console.log("no mentor evaluator");
            this.mentEvalPresentStatus="There is No Mentor and Evaluator Assigned for this Group";
        }



       }

    });



  }





 onSelectTech(tech11:string): void{
        this.tech1=tech11;
          console.log(this.tech1);
        this.groupObj=[];
         this.AssignMentorEvaluatorService.getMentees(this.mentee).subscribe(
      res => {
        if(res.status == 200)
          {
            console.log(res);
              
            console.log("route to adduset");
           this.getGroup();
             
          }else{
            console.log("route to tes aduser");
            
            console.log(res);
          }
      },
       err => {
         console.log(err);
         console.log("route to adduser error");
        return err;
          
      }
    );
       



      }



       getGroup() : void {
    console.log("in get getGroup()");
     var currentGroups =JSON.parse(localStorage.getItem('GroupsDetail'));
     console.log(currentGroups);
     

    currentGroups.map(group => {
        this.groupObj.push(group);
      
      console.log(group.groupName);
   
      group.mentees.map(mentee=>{

        console.log(mentee.menteeName);
       
      });

      
       

    });
  }


}
