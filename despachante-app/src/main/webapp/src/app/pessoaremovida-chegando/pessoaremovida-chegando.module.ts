import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { MpmUiModule, MpmMaterialModule } from '@mpm/ng';

import { PessoaremovidaChegandoListaComponent } from './pessoaremovida-chegando-lista/pessoaremovida-chegando-lista.component';


@NgModule({
  declarations: [
    PessoaremovidaChegandoListaComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MpmUiModule,
    MpmMaterialModule
  ]
})
export class PessoaremovidaChegandoModule { }
