import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaremovidaChegandoListaComponent } from './pessoaremovida-chegando-lista.component';

describe('PessoaremovidaChegandoListaComponent', () => {
  let component: PessoaremovidaChegandoListaComponent;
  let fixture: ComponentFixture<PessoaremovidaChegandoListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PessoaremovidaChegandoListaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PessoaremovidaChegandoListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
