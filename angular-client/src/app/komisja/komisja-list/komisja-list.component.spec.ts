import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KomisjaListComponent } from './komisja-list.component';

describe('KomisjaListComponent', () => {
  let component: KomisjaListComponent;
  let fixture: ComponentFixture<KomisjaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KomisjaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KomisjaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
