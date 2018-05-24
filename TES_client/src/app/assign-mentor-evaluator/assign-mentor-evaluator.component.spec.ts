import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignMentorEvaluatorComponent } from './assign-mentor-evaluator.component';

describe('AssignMentorEvaluatorComponent', () => {
  let component: AssignMentorEvaluatorComponent;
  let fixture: ComponentFixture<AssignMentorEvaluatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssignMentorEvaluatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignMentorEvaluatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
