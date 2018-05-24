//import { Response } from '_debugger';
import { ContentType } from '@angular/http/src/enums';
import { Resolve } from '@angular/router';
import { Injectable } from '@angular/core';
import { Http, Response,Headers,RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import {User} from './user';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class LoginService {
private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) { }

   loginFunction(user: User): Observable<any>{
    // return this.http.post('login',}).map((response: Response) => {
    //   return response.json();
    console.log("inside loginFunction");
    console.log(user.userName);
  //    console.log(res.json());
      // return this.http
      // .post("login", JSON.stringify(user), {headers : this.headers})
      // .toPromise()
      // .then(res => res.json() as String[])
      // .catch(this.handleError);
       return this.http
      .post("login", JSON.stringify(user),{headers : this.headers})
      .map(
      res => {
        if (res.status == 200) {
          localStorage.setItem('currentUser', JSON.stringify(res.json()));
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

  logout() {
    localStorage.removeItem('currentUser');
  }

  private handleError(error: any): Promise<any> {
    console.error('Error', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
