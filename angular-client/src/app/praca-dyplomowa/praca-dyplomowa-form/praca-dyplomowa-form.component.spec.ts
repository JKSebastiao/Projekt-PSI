import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PracaDyplomowaFormComponent } from './praca-dyplomowa-form.component';

describe('PracaDyplomowaFormComponent', () => {
  let component: PracaDyplomowaFormComponent;
  let fixture: ComponentFixture<PracaDyplomowaFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PracaDyplomowaFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PracaDyplomowaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
