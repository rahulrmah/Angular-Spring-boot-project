import { Injectable } from '@angular/core';
import { ContentType } from '@angular/http/src/enums';
import { Resolve } from '@angular/router';

import { Http, Response,Headers,RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import {User} from './user';
import {Mentee} from './mentees';
import { Observable } from 'rxjs/Rx';
import { UserRole } from './userRole';
@Injectable()
export class AssignMentorEvaluatorService {
private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) { }




getEvaluator(groupId:number): Observable<any>{
    
    console.log("inside getMentorEvaluator service");
    console.log(groupId);
   
 const url2 = `getEvaluator/${groupId}`;
       return this.http
       .get(url2)
       .map(   
      res => {
        if (res.status == 200) {
          localStorage.setItem('EvlData', JSON.stringify(res.json()));
          console.log("success");
        }
        console.log(res.json().status);
        console.log(res);
        return res;
      },
      err => {
        console.log(err);
        console.log("error")
        return err;
      }
      )
    
  }  



getMentor(groupId:number): Observable<any>{
    
    console.log("inside getMentorEvaluator service");
    console.log(groupId);
   
 const url2 = `getMentor/${groupId}`;
       return this.http
       .get(url2)
       .map(   
      res => {
        if (res.status == 200) {
          localStorage.setItem('mentorData', JSON.stringify(res.json()));
          console.log("success");
        }
        console.log(res.json().status);
        console.log(res);
        return res;
      },
      err => {
        console.log(err);
        console.log("error")
        return err;
      }
      )
    
  }  











assignUser(userId: number,groupId:number,userType:string): Observable<any>{
    
    console.log("inside assignUser service");
    console.log(userId);
   console.log(groupId);
   console.log(userType);

    const url = `assignMentorEvaluator/${userId}/${groupId}/${userType}`;
       return this.http
      .get(url)
      .map(
      res => {
        if (res.status == 200) {
          localStorage.setItem('assignStatus', JSON.stringify(res.json()));
          console.log("success");
        }
        console.log(res.json().status);
        console.log(res);
        return res;
      },
      err => {
        console.log(err);
        console.log("error")
        return err;
      }
      )
    
  }  

getrollwiseUser(userRoles: UserRole,technology:String): Observable<any>{
    
    console.log("inside getMentees Function");
    console.log(userRoles.role);
    const url1 = `getByroleName/${technology}`;
       return this.http
      .post(url1, JSON.stringify(userRoles),{headers : this.headers})
      .map(
      res => {
        if (res.status == 200) {
          localStorage.setItem('roleDetails', JSON.stringify(res.json()));
          console.log("success");
        }
        console.log(res.json().status);
        console.log(res);
        return res;
      },
      err => {
        console.log(err);
        console.log("error")
        return err;
      }
      )
    
  }  

getMentees(mentees: Mentee): Observable<any>{
    
    console.log("inside getMentees Function");
    console.log(mentees.technology);
  
       return this.http
      .post("getGroups", JSON.stringify(mentees),{headers : this.headers})
      .map(
      res => {
        if (res.status == 200) {
          localStorage.setItem('GroupsDetail', JSON.stringify(res.json()));
          console.log("success");
        }
        console.log(res.json().status);
        console.log(res);
        return res;
      },
      err => {
        console.log(err);
        console.log("error")
        return err;
      }
      )
    
  }

}
