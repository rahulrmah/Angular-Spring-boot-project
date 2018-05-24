import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TesMainComponent } from './tes-main.component';

describe('TesMainComponent', () => {
  let component: TesMainComponent;
  let fixture: ComponentFixture<TesMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TesMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TesMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
