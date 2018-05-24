import { Component, OnInit , Input} from '@angular/core';
import { TrainerComponent } from '../trainer/trainer.component';
import { MentorComponent } from '../mentor/mentor.component';
@Component({
  selector: 'app-tes-main',
  templateUrl: './tes-main.component.html',
  styleUrls: ['./tes-main.component.css']
})
export class TesMainComponent{

  trainer : String;
  mentor : String;
  training : String;
  evaluator : String;
  sme : String;
  username:String="";
  constructor() { }

  ngOnInit() {
      this.getRoles();
  }

  getRoles() : void {
    console.log("in get roles()");
     var currentUser =JSON.parse(localStorage.getItem('currentUser'));
     console.log(currentUser.userName);
      this.username=currentUser.userName;

    currentUser.userRoles.map(role => {
      console.log(role);
        if(role.role=="Trainer")
          this.trainer="trainer";
        else if(role.role=="Mentor")
          this.mentor="mentor";
        else if(role.role=="Evaluator")
          this.evaluator="evaluator";
        else if(role.role=="SME")
          this.sme="sme";
        else if(role.role=="Training")
          this.training="training";


    });
  }
}
