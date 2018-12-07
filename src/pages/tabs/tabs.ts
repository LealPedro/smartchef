import { Component } from '@angular/core';

import { CadastroPage } from '../cadastro/cadastro';
import { BuscaPage } from '../busca/busca';

@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {

  tab1Root = CadastroPage;
  tab2Root = BuscaPage;

  constructor() {

  }
}
