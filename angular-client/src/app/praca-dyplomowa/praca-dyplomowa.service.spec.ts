import { TestBed } from '@angular/core/testing';

import { PracaDyplomowaService } from './praca-dyplomowa.service';

describe('PracaDyplomowaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PracaDyplomowaService = TestBed.get(PracaDyplomowaService);
    expect(service).toBeTruthy();
  });
});
