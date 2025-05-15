import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { MpmUiModule, MpmMaterialModule } from '@mpm/ng';
import { ConfiguracaoListaComponent } from './configuracao-lista/configuracao-lista.component';
import { ConfiguracaoFormComponent } from './configuracao-form/configuracao-form.component';

@NgModule({
  declarations: [
    ConfiguracaoListaComponent, 
    ConfiguracaoFormComponent],
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
export class ConfiguracaoModule { }
