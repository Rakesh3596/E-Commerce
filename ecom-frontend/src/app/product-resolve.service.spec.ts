import { TestBed } from '@angular/core/testing';

import { ProductResolveService } from './product-resolve.service';

describe('ProductResolveService', () => {
  let service: ProductResolveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductResolveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
