import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-relatorio',
  templateUrl: './relatorio.component.html',
  styleUrls: ['./relatorio.component.css']
})
export class RelatorioComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  formRelatorioParaMPM = new FormGroup({
  });

  formRelatorioDoMPM = new FormGroup({
  });

  onGerarRelatorio() {
  }


}
