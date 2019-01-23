import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PowolanieComponent } from './powolanie.component';

describe('PowolanieComponent', () => {
  let component: PowolanieComponent;
  let fixture: ComponentFixture<PowolanieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PowolanieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PowolanieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
