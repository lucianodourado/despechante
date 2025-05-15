import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { MpmUiModule, MpmMaterialModule } from '@mpm/ng';
import { RelatorioComponent } from './relatorio.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MpmUiModule,
    MpmMaterialModule,

  ],
  declarations: [RelatorioComponent],
  exports: [RelatorioComponent]
})
export class RelatorioModule { }