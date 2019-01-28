import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecenzentPropozycjaComponent } from './recenzent-propozycja.component';

describe('RecenzentPropozycjaComponent', () => {
  let component: RecenzentPropozycjaComponent;
  let fixture: ComponentFixture<RecenzentPropozycjaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecenzentPropozycjaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecenzentPropozycjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
