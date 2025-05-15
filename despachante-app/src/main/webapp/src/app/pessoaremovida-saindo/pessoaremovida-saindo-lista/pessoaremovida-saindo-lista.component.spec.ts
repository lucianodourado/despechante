import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaRemovidaSaindoListaComponent } from './pessoaremovida-saindo-lista.component';

describe('PessoaRemovidaSaindoListaComponent', () => {
  let component: PessoaRemovidaSaindoListaComponent;
  let fixture: ComponentFixture<PessoaRemovidaSaindoListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PessoaRemovidaSaindoListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PessoaRemovidaSaindoListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
