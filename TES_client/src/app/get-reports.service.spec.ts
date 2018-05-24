import { TestBed, inject } from '@angular/core/testing';

import { GetReportsService } from './get-reports.service';

describe('GetReportsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetReportsService]
    });
  });

  it('should be created', inject([GetReportsService], (service: GetReportsService) => {
    expect(service).toBeTruthy();
  }));
});
