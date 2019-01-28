import { TestBed } from '@angular/core/testing';
import { KomisjaEgzaminacyjnaService } from '../komisja-egzaminacyjna.service';


describe('PowolanieService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: KomisjaEgzaminacyjnaService = TestBed.get(KomisjaEgzaminacyjnaService);
    expect(service).toBeTruthy();
  });
});
