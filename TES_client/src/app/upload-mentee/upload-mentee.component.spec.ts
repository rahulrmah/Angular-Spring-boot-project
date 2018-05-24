import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadMenteeComponent } from './upload-mentee.component';

describe('UploadMenteeComponent', () => {
  let component: UploadMenteeComponent;
  let fixture: ComponentFixture<UploadMenteeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadMenteeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadMenteeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
