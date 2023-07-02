import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BatchDetailsComponent } from './batch-details.component';

describe('BatchDetailsComponent', () => {
  let component: BatchDetailsComponent;
  let fixture: ComponentFixture<BatchDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BatchDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BatchDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
