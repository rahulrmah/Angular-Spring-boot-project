import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import { TesMainComponent } from './tes-main/tes-main.component';
import { MentorComponent } from './mentor/mentor.component'
import { LoginComponent } from './login/login.component'
import { AuthguardService } from './authguard.service'
import {TrainingComponent} from './training/training.component'
import { UploadMenteeComponent } from './upload-mentee/upload-mentee.component';
import { UploadOttComponent } from './upload-ott/upload-ott.component';
import { AssignMentorEvaluatorComponent } from './assign-mentor-evaluator/assign-mentor-evaluator.component';
import { AddUserComponent } from './add-user/add-user.component';
import { CreateGroupComponent } from './create-group/create-group.component';
import { FinalReportComponent } from './final-report/final-report.component';

const routes: Routes = [
  
  { path: 'login', component: LoginComponent },
    { path: 'index', component: TesMainComponent,canActivate: [AuthguardService],
    children: [
        {path: '', redirectTo: 'login', pathMatch: 'full'},
        {path: 'app-upload-mentee', component: UploadMenteeComponent,canActivate: [AuthguardService]},
        {path: 'app-upload-ott', component: UploadOttComponent,canActivate: [AuthguardService]},
        {path: 'app-assign-mentor-evaluator', component: AssignMentorEvaluatorComponent,canActivate: [AuthguardService]},
        {path: 'app-add-user', component: AddUserComponent,canActivate: [AuthguardService]},
        {path: 'app-create-group', component: CreateGroupComponent,canActivate: [AuthguardService]},
        {path: 'app-final-report', component: FinalReportComponent,canActivate: [AuthguardService]}
      ] },
 
    // otherwise redirect to home
   { path: '**', redirectTo: '/login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
