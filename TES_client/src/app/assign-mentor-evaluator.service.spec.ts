import { TestBed, inject } from '@angular/core/testing';

import { AssignMentorEvaluatorService } from './assign-mentor-evaluator.service';

describe('AssignMentorEvaluatorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AssignMentorEvaluatorService]
    });
  });

  it('should be created', inject([AssignMentorEvaluatorService], (service: AssignMentorEvaluatorService) => {
    expect(service).toBeTruthy();
  }));
});
