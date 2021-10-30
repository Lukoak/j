/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import baco.BaoProdutos;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author akzer
 */
public class Controllerprodutos {
    private BaoProdutos baoProdutos = new BaoProdutos();
    
    public int salvarProdutoController(ModelProdutos pModelProdutos){
        return this.baoProdutos.salvarProdutosBAO(pModelProdutos);                
    }
    
    public boolean excluirProdutoController (int pCodigo){
        return this.baoProdutos.excluirProdutoBAO(pCodigo);
    }
    
    public boolean alterarProdutoController (ModelProdutos pModelProdutos){
        return this.baoProdutos.alterarProdutoBAO(pModelProdutos);
    }
    
    public ModelProdutos retornarProdutoController (int pCodigo){
        return this.baoProdutos.retornarProdutoBAO(pCodigo);
    }
    
    /*
    retorna lista de produtos
    */    
    public ArrayList<ModelProdutos> retornarListaProdutoController(){
        return this.baoProdutos.retornarListaProdutosBAO();
    }
       
};
