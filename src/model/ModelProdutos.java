/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author akzer
 */
public class ModelProdutos {
    private int codProduto;
    private String nomeProd;
    private float valorProd;
    private float qtEstoque;

    /**
     * @return the codProduto
     */
    public int getCodProduto() {
        return codProduto;
    }

    /**
     * @param codProduto the codProduto to set
     */
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    /**
     * @return the nomeProd
     */
    public String getNomeProd() {
        return nomeProd;
    }

    /**
     * @param nomeProd the nomeProd to set
     */
    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    /**
     * @return the valorProd
     */
    public float getValorProd() {
        return valorProd;
    }

    /**
     * @param valorProd the valorProd to set
     */
    public void setValorProd(float valorProd) {
        this.valorProd = valorProd;
    }

    /**
     * @return the qtEstoque
     */
    public float getQtEstoque() {
        return qtEstoque;
    }

    /**
     * @param qtEstoque the qtEstoque to set
     */
    public void setQtEstoque(float qtEstoque) {
        this.qtEstoque = qtEstoque;
    }
    
    
}
