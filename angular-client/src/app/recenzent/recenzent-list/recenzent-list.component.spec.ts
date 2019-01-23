import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecenzentListComponent } from './recenzent-list.component';

describe('RecenzentListComponent', () => {
  let component: RecenzentListComponent;
  let fixture: ComponentFixture<RecenzentListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecenzentListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecenzentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
