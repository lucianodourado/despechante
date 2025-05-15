import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpParams } from '@angular/common/http';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';

import { MpmHttpService } from '@mpm/ng';
import { environment } from 'src/environments/environment';
import { MpmAuthService } from '@mpm/ng/auth';

import { ConfiguracaoFormComponent } from 'src/app/configuracao/configuracao-form/configuracao-form.component'

import { Configuracao } from '../configuracao.model'

@Component({
  selector: 'configuracao-lista',
  templateUrl: './configuracao-lista.component.html',
  styleUrls: ['./configuracao-lista.component.css']
})
export class ConfiguracaoListaComponent implements OnInit {

  listaConfiguracoes: Configuracao[];

  constructor(
    private mpmHttp: MpmHttpService,
    private dialog: MatDialog,
    public snackBar: MatSnackBar,    
    public authService: MpmAuthService) {
  }

  ngOnInit() {
    this.exibeListagem();
  }

  preencheGrid() {
    this.mpmHttp.get(environment.apiPath + `/internal/v1/configuracoes/`,
      new HttpParams())
      .subscribe(
        (res: any) => {
          this.listaConfiguracoes = res;
        },
        (message: any) => {
          this.exibeMensagem('Erro ao recuperar os dados: ' + message)
        }
      );
  }

  exibeListagem() {
    this.preencheGrid();
  }

  exibeMensagem(message: string) {
    this.snackBar.open(message, "X", { duration: 10000 })
  }

  gridPageChanged(event) {
    this.preencheGrid();
  }

  gridSortChanged(event) {
    this.preencheGrid();
  }

  rowSelected(item: any) {
  }

  editarRegistro(row: any) {
    const registro = {
      ramo: row.ramo,
    }
    this.abrirPopup(registro)
  }  

  abrirPopup(registro) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.panelClass = 'custom-mat-dialog-container';
    dialogConfig.autoFocus = true;
    dialogConfig.width = "70%";
    dialogConfig.data = registro;

    // abre em popup
    const dialogRef = this.dialog.open(ConfiguracaoFormComponent, dialogConfig);

    // atualizar ao voltar 
    dialogRef.afterClosed().subscribe(() => this.preencheGrid());
  }


}