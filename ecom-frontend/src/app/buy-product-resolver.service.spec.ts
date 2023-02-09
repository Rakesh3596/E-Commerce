import { TestBed } from '@angular/core/testing';

import { BuyProductResolverService } from './buy-product-resolver.service';

describe('BuyProductResolverService', () => {
  let service: BuyProductResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuyProductResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
