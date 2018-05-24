import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { UploadFileService } from '.././upload-file.service';

@Component({
  selector: 'app-upload-ott',
  templateUrl: './upload-ott.component.html',
  styleUrls: ['./upload-ott.component.css']
})
export class UploadOttComponent implements OnInit {

  selectedFiles: FileList
  currentFileUpload: File
  progress: { percentage: number } = { percentage: 0 }
  uploadStatus: string = "";
  constructor(private uploadService: UploadFileService) { }

  ngOnInit() {
     this.uploadStatus="";
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    
    this.progress.percentage = 0;
     if(this.selectedFiles)
    this.currentFileUpload = this.selectedFiles.item(0);

     if(this.selectedFiles){
  

      if(confirm("Do you want to Upload OTT List ?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
   {
    this.uploadService.pushOttFileToStorage(this.currentFileUpload).subscribe(event => {
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
