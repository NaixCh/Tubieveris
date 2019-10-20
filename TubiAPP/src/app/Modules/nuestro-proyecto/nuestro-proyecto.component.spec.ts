import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NuestroProyectoComponent } from './nuestro-proyecto.component';

describe('NuestroProyectoComponent', () => {
  let component: NuestroProyectoComponent;
  let fixture: ComponentFixture<NuestroProyectoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NuestroProyectoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NuestroProyectoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
