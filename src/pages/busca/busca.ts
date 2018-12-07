import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ProdutoProvider } from '../../providers/produto/produto';

/**
 * Generated class for the BuscaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-busca',
  templateUrl: 'busca.html',
  providers: [
    ProdutoProvider
  ]
})
export class BuscaPage {

  listaProdutos = [];

  constructor(public navCtrl: NavController, public navParams: NavParams, private prodPvr: ProdutoProvider) {
  }

  ionViewDidEnter() {
    this.carregaLista();
  }

carregaLista() {
    this.prodPvr.listProduto().subscribe(
      (data: any)=>{
        this.listaProdutos = JSON.parse(data._body);
      },
      (error: any)=>{
        console.log(error._body);
      }
    );
  }

}
