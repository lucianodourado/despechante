import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { MpmUiModule, MpmMaterialModule } from '@mpm/ng';
import { PessoaRemovidaSaindoListaComponent } from './pessoaremovida-saindo-lista/pessoaremovida-saindo-lista.component';

@NgModule({
  declarations: [
    PessoaRemovidaSaindoListaComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MpmUiModule,
    MpmMaterialModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt-BR' }
  ]
})
export class PessoaRemovidaSaindoModule { }
