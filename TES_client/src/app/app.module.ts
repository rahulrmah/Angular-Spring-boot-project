import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { LoginService } from './login.service';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule} from '@angular/http';
import { TrainingComponent } from './training/training.component';
import { TesMainComponent } from './tes-main/tes-main.component';
import { TrainerComponent } from './trainer/trainer.component';
import { MentorComponent } from './mentor/mentor.component';
import { SmeComponent } from './sme/sme.component';
import { EvaluatorComponent } from './evaluator/evaluator.component';
import { AppRoutingModule } from './/app-routing.module';
import {APP_BASE_HREF} from '@angular/common';
import { AuthguardService } from './authguard.service';
import { UploadMenteeComponent } from './upload-mentee/upload-mentee.component'
import {HttpClientModule} from '@angular/common/http';
import {UploadFileService} from './upload-file.service';
import { UploadOttComponent } from './upload-ott/upload-ott.component';
import { AssignMentorEvaluatorComponent } from './assign-mentor-evaluator/assign-mentor-evaluator.component';
import { AddUserComponent } from './add-user/add-user.component';
import { CreateGroupComponent } from './create-group/create-group.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GridModule } from '@progress/kendo-angular-grid';
import { FinalReportComponent } from './final-report/final-report.component';
import { GetReportsService } from './get-reports.service';
import { AddUserService } from './add-user.service';
import { CreateGroupService } from './create-group.service';
import { AssignMentorEvaluatorService } from "./assign-mentor-evaluator.service";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TrainingComponent,
    TesMainComponent,
    TrainerComponent,
    MentorComponent,
    SmeComponent,
    EvaluatorComponent,
    UploadMenteeComponent,
    UploadOttComponent,
    AssignMentorEvaluatorComponent,
    AddUserComponent,
    CreateGroupComponent,
    FinalReportComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    GridModule
  ],
  providers: [LoginService,AuthguardService,UploadFileService,GetReportsService,AddUserService,CreateGroupService,AssignMentorEvaluatorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
