import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowProductImagesDialogComponent } from './show-product-images-dialog.component';

describe('ShowProductImagesDialogComponent', () => {
  let component: ShowProductImagesDialogComponent;
  let fixture: ComponentFixture<ShowProductImagesDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowProductImagesDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowProductImagesDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
