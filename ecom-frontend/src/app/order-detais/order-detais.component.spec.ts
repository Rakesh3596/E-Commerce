import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderDetaisComponent } from './order-detais.component';

describe('OrderDetaisComponent', () => {
  let component: OrderDetaisComponent;
  let fixture: ComponentFixture<OrderDetaisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderDetaisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderDetaisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
