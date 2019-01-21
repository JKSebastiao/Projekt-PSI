import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PracaDyplomowaListComponent } from './praca-dyplomowa-list.component';

describe('PracaDyplomowaListComponent', () => {
  let component: PracaDyplomowaListComponent;
  let fixture: ComponentFixture<PracaDyplomowaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PracaDyplomowaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PracaDyplomowaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
