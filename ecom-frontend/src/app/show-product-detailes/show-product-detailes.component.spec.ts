import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowProductDetailesComponent } from './show-product-detailes.component';

describe('ShowProductDetailesComponent', () => {
  let component: ShowProductDetailesComponent;
  let fixture: ComponentFixture<ShowProductDetailesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowProductDetailesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowProductDetailesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
