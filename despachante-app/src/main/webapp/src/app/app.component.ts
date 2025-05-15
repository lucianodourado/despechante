import { Component } from '@angular/core';
import { MpmAuthService } from '@mpm/ng/auth';
import { MpmSpinnerService } from '@mpm/ng/ui';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'despachante-app';

  constructor(public authService: MpmAuthService,
              public mpmSpinnerService: MpmSpinnerService) {
  }

  showTitulo() {
    return true;
  }

  showMenu() {
    return this.authService.autenticado.value;
  }

  showSpinner(){
    return this.mpmSpinnerService.isLoading();
  }
}