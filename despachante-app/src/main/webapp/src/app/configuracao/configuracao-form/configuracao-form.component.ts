import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,  Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { MpmHttpService } from '@mpm/ng';
import { MpmNotificationService } from '@mpm/ng';
import { environment } from 'src/environments/environment';
import { Configuracao } from '../configuracao.model';

@Component({
  selector: 'configuracao-form',
  templateUrl: './configuracao-form.component.html',
  styleUrls: ['./configuracao-form.component.css']
})
export class ConfiguracaoFormComponent implements OnInit {

  ramo: String;
  formulario: FormGroup;
  configuracao: Configuracao; 

  constructor(
    private mpmHttp: MpmHttpService,
    private formBuilder: FormBuilder,    
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<ConfiguracaoFormComponent>,
    private notificationService: MpmNotificationService
  ) { 
    this.ramo = data.ramo;
  }
  
  ngOnInit(): void {
    this.configuraFormulario();
    this.getRegistro();    
  }

  configuraFormulario() {
    this.formulario = this.formBuilder.group({
      ramo: [null, Validators.required], 
      urlToken: [null, Validators.required],
      urlPessoa: [null, Validators.required],
      urlErro: [null, Validators.required],
      ativo: [null, Validators.required], 
      usuario: [null, Validators.required],
      senha: [null, Validators.required]
    });
  
  }

  private getRegistro(): void {
    this.mpmHttp.get(environment.apiPath + `/internal/v1/configuracoes/${this.ramo}`)
      .subscribe(
        (data: any) => {
          this.configuracao = data;
          this.formulario.patchValue(this.configuracao);          
        }
      );
  }

  public voltar() {
    this.dialogRef.close();
  }
  
  public onSubmit() {
    this.save();
  }

  private save() {
    if (this.formulario.valid) {

      let dados = this.formulario.getRawValue();
        this.mpmHttp.put(environment.apiPath + `/internal/v1/configuracoes/${this.ramo}`, dados)
          .subscribe(
            (data: any) => {
              this.notificationService.warn('Dados alterados com sucesso!');
              this.voltar();
            },
          );
      } else {
      this.notificationService.erro('Verifique campo(s) com preenchimento obrigatório (*)', 10000);
    }
  }

}
