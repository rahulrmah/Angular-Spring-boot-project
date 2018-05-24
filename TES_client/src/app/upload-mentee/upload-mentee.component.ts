import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { UploadFileService } from '.././upload-file.service';

@Component({
  selector: 'app-upload-mentee',
  templateUrl: './upload-mentee.component.html',
  styleUrls: ['./upload-mentee.component.css']
})
export class UploadMenteeComponent implements OnInit {

 selectedFiles: FileList
  currentFileUpload: File
  
  progress: { percentage: number } = { percentage: 0 }

  constructor(private uploadService: UploadFileService) { }

  ngOnInit() {
   
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {


   
    this.progress.percentage = 0;
 if(this.selectedFiles)
    this.currentFileUpload = this.selectedFiles.item(0);

    if(this.selectedFiles){

    

      if(confirm("Do you want to Upload Mentees List ?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
   {
    this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
       
        alert( "File is completely uploaded!");
      }else{
        alert( "File Failed to upload!");
      }
    })

    this.selectedFiles = undefined

     }else{
       return false;
    }
    }else{
      alert( "Please select File  !!!");
    }
  }
}
