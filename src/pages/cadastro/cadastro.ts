import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController } from 'ionic-angular';
import { ProdutoProvider } from '../../providers/produto/produto';

/**
 * Generated class for the CadastroPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-cadastro',
  templateUrl: 'cadastro.html',
  providers: [
    ProdutoProvider
  ]

})
export class CadastroPage {

  nome: string;
  tamanho: string;
  valor: number;

  constructor(public navCtrl: NavController, public navParams: NavParams, private prodPvr: ProdutoProvider, private toast: ToastController ) {
  }

  ionViewDidLoad() {}

  createProduct() {
    this.prodPvr.setProduto(this.nome, this.tamanho, this.valor)
    .then((result: any) => {
      this.toast.create({message: 'Produto cadastrado com sucesso. ', position: 'botton', duration: 3000 }).present();
    })
    .catch((error: any) => {
      this.toast.create({ message: 'Erro ao cadastrar produto. Erro: ' + error.error, position: 'botton', duration: 3000 }).present();
    });
  }

}
