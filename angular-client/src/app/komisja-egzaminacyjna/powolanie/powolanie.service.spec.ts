import { TestBed } from '@angular/core/testing';

import { PowolanieService } from './powolanie.service';

describe('PowolanieService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PowolanieService = TestBed.get(PowolanieService);
    expect(service).toBeTruthy();
  });
});
