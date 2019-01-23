import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KomisjaEgzaminacyjnaComponent } from './komisja-egzaminacyjna.component';

describe('KomisjaEgzaminacyjnaComponent', () => {
  let component: KomisjaEgzaminacyjnaComponent;
  let fixture: ComponentFixture<KomisjaEgzaminacyjnaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KomisjaEgzaminacyjnaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KomisjaEgzaminacyjnaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
