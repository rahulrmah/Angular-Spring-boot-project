import { Injectable } from '@angular/core';
import { ContentType } from '@angular/http/src/enums';
import { Resolve } from '@angular/router';
import { Http, Response,Headers,RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class CreateGroupService {

  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) { }

  private handleError(error: any): Promise<any> {
    console.error('Error', error); 
    return Promise.reject(error.message || error);
  }

  getJavaMentees(): Promise<any>{
    return this.http.get("getJavaMentees")
    .toPromise()
    .then(response =>{ 
      sessionStorage.setItem('javaMentees', JSON.stringify(response.json()));
      console.log(response.json());
      response.json() as any
    })
    .catch(this.handleError);
  }

  getDotNetMentees(): Promise<any>{
    return this.http.get("getDotNetMentees")
    .toPromise()
    .then(response =>{ 
      sessionStorage.setItem('dotNetMentees', JSON.stringify(response.json()));
      console.log(response.json());
      response.json() as any
    })
    .catch(this.handleError);
  }

  getFETMentees(): Promise<any>{
    return this.http.get("getFETMentees")
    .toPromise()
    .then(response =>{ 
      sessionStorage.setItem('fetMentees', JSON.stringify(response.json()));
      console.log(response.json());
      response.json() as any
    })
    .catch(this.handleError);
  }

  createGroup(mentees: number[],groupName:String): Promise<any> {
    const url = `addGroup/${groupName}`;
    return this.http
      .post(url, JSON.stringify(mentees), {headers : this.headers})
      .toPromise()
      .then(res => res.json() as any)
      .catch(this.handleError);
  }
}


