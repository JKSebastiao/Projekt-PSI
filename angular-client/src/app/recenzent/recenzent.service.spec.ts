import { TestBed } from '@angular/core/testing';

import { RecenzentService } from './recenzent.service';

describe('RecenzentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RecenzentService = TestBed.get(RecenzentService);
    expect(service).toBeTruthy();
  });
});
