import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';
import { Http, Response,Headers,RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import {User} from './user';
import { Observable } from 'rxjs/Rx';
import { ContentType } from '@angular/http/src/enums';
import { Resolve } from '@angular/router';

@Injectable()
export class AddUserService {

  temp : String = " ";

private headers = new Headers({
                'Content-Type': 'application/json; charset=UTF-8',
                'Accept': 'application/json; charset=UTF-8'
            });

  constructor(private http: Http) { }


   create(user1: User):Promise<User>{
    
    console.log("inside CreateFunction of service");
    console.log(user1.userName);
     console.log(user1.userRoles);
     const url = `addUser/${user1.userName}/${user1.technology}/${user1.userRoles}`;
      return this.http
      .get(url)
      .toPromise()
      .then(res => res.json() as User)
      .catch(this.handleError);
    
       
    // return this.http.post(url,any)
    //   .toPromise()
    //   .then(response => response.json() as string)
    //   .catch(this.handleError);
  }
  
  

 private handleError(error: any): Promise<any> {
    console.error('Error', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
