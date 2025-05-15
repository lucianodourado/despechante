import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MpmAuthGuard } from '@mpm/ng';
import { LoginComponent } from "@mpm/ng/ui";
import { PessoaRemovidaSaindoListaComponent } from './pessoaremovida-saindo/pessoaremovida-saindo-lista/pessoaremovida-saindo-lista.component';
import { PessoaremovidaChegandoListaComponent } from './pessoaremovida-chegando/pessoaremovida-chegando-lista/pessoaremovida-chegando-lista.component';
import { RelatorioComponent } from './relatorio/relatorio.component';
import { ConfiguracaoListaComponent } from './configuracao/configuracao-lista/configuracao-lista.component';

const routes: Routes = [
    {
        path: 'login', 
        component: LoginComponent
    },
    {
        path: 'logout', 
        component: LoginComponent
    },    
    {
        path: 'home', 
        component: PessoaRemovidaSaindoListaComponent,
        canActivate: [MpmAuthGuard]
    },
    {
        path: 'pessoa-saindo-lista', 
        component: PessoaRemovidaSaindoListaComponent,
        canActivate: [MpmAuthGuard]
    },
    {
        path: 'pessoa-chegando-lista', 
        component: PessoaremovidaChegandoListaComponent,
        canActivate: [MpmAuthGuard]
    },
    {
        path: 'configuracao-lista', 
        component: ConfiguracaoListaComponent,
        canActivate: [MpmAuthGuard]
    },
    {
        path: 'relatorios',
        component: RelatorioComponent,
        canActivate: [MpmAuthGuard]
    },
    {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { useHash: true })],
    exports: [RouterModule]
})
export class AppRoutingModule { }
