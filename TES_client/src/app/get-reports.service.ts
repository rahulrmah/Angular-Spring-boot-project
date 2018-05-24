import { Injectable } from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
 import {Observable} from "rxjs/Observable";

@Injectable()
export class GetReportsService {

  constructor(private http: HttpClient) { }

  getFinalReports(): Observable<any> {
    return this.http
             .get('/finalReport')
             .map( res => {
        // if (res.status == 200) {
        //   localStorage.setItem('currentUser', JSON.stringify(res.json()));
        //   console.log("success");
        // }
        //console.log(res.json().status);
        console.log(res);
        return res;
      },
      err => {
        console.log(err);
        console.log("error")
        return err;
      })
             .catch(this.handleError);
  }

  private handleError(error: Response) {
         return Observable.throw(error.statusText);
  }
}
