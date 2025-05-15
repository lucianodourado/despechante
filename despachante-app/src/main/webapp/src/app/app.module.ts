import { NgModule, LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { registerLocaleData } from '@angular/common';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import localePt from '@angular/common/locales/pt';

import { MpmAuthModule, MpmHttpModule, MpmMaterialModule, MpmUiModule } from '@mpm/ng';


import { environment } from '../environments/environment';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { mpmMenu } from './mpm-menu';

import { PessoaRemovidaSaindoModule } from './pessoaremovida-saindo/pessoaremovida-saindo.module';
import { PessoaremovidaChegandoModule } from './pessoaremovida-chegando/pessoaremovida-chegando.module';
import { RelatorioModule } from './relatorio/relatorio.module';
import { ConfiguracaoModule } from './configuracao/configuracao.module';

registerLocaleData(localePt, 'pt-BR');

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MpmMaterialModule,
    MpmAuthModule,
    FlexLayoutModule,    
    MpmUiModule,
    MpmHttpModule,
    PessoaRemovidaSaindoModule,
    PessoaremovidaChegandoModule,    
    ConfiguracaoModule,
    RelatorioModule
  ],
  providers: [
    {
      provide: 'environment', useValue: environment
    },
    {
      provide: 'mpmMenu', useValue: mpmMenu
    },
    { 
      provide: LOCALE_ID, useValue: 'pt-BR' 
    },
    { 
      provide: MAT_DATE_LOCALE, useValue: 'pt-BR' 
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
