import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KomisjaFormComponent } from './komisja-form.component';

describe('KomisjaFormComponent', () => {
  let component: KomisjaFormComponent;
  let fixture: ComponentFixture<KomisjaFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KomisjaFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KomisjaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
