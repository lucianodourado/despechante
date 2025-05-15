import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { HttpParams } from '@angular/common/http';
import { fromEvent as observableFromEvent } from 'rxjs';
import { distinctUntilChanged, debounceTime } from 'rxjs/operators';

import { MpmHttpService } from '@mpm/ng';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'pessoaremovida-saindo-lista',
  templateUrl: './pessoaremovida-saindo-lista.component.html',
  styleUrls: ['./pessoaremovida-saindo-lista.component.css']
})
export class PessoaRemovidaSaindoListaComponent implements OnInit {
  dataSource: MatTableDataSource<any>;

  @ViewChild('filter', { static: true })
  filter: ElementRef;

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;

  //Colunas visiveis do grid
  displayedColumns = ['matricula', 'cpf', 'nome', 'acao'];

  constructor(
    private mpmHttp: MpmHttpService,
    private router: Router,
    public snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.sort.active = 'matricula';
    this.sort.direction = 'asc';
    this.paginator.pageSize = 10;
    this.paginator.pageSizeOptions = [1, 5, 10, 25, 100];
    this.paginator._intl.itemsPerPageLabel = 'itens por página:';

    this.exibeListagem();

    //Configura o filtro do grid    
    observableFromEvent(this.filter.nativeElement, 'keyup').pipe(
      debounceTime(300),
      distinctUntilChanged())
      .subscribe(() => {
        if (this.dataSource) {
          this.preencheGrid();
        }
      });
  }

  preencheGrid() {
    this.mpmHttp.get(environment.apiPath + `/internal/v1/pessoa/saindo/?`,
      new HttpParams()
        // paginação
        .append('page', this.paginator.pageIndex.toString())
        .append('size', this.paginator.pageSize.toString())
        .append('sort', this.sort.active + ',' + this.sort.direction)
        // filtro
        .append('filtro', this.filter.nativeElement.value)
    )
      .subscribe(
        (res: any) => {
          this.dataSource = new MatTableDataSource(res.content);
          this.paginator.pageSize = res.pageable.pageSize;
          this.paginator.pageIndex = res.pageable.pageNumber;
          this.paginator.length = res.totalElements;
          console.log(res.content);          
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

}