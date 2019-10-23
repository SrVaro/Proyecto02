import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscardsComponent } from './discards.component';

describe('DiscardsComponent', () => {
  let component: DiscardsComponent;
  let fixture: ComponentFixture<DiscardsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiscardsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
