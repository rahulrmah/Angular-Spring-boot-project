import { Component, OnInit } from '@angular/core';
import { GetReportsService } from '../get-reports.service';

@Component({
  selector: 'app-final-report',
  templateUrl: './final-report.component.html',
  styleUrls: ['./final-report.component.css']
})
export class FinalReportComponent implements OnInit {

  public gridData: any[];
   
  constructor(private GetReportsService:GetReportsService) { }


  ngOnInit() {
     this.GetReportsService.getFinalReports().subscribe(
      res => {
        this.gridData =res;
        console.log(this.gridData);
        console.log(res);
      },
       err => {
         console.log(err);
         console.log("route to tes error");
        return err;
          
      }
    );
  }

}
