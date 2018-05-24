import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadOttComponent } from './upload-ott.component';

describe('UploadOttComponent', () => {
  let component: UploadOttComponent;
  let fixture: ComponentFixture<UploadOttComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadOttComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadOttComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
