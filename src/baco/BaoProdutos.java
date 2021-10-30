/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baco;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 * cadastrar produto banco
 *
 * @author Lucas
 */
public class BaoProdutos extends ConexaoMySql {

    public int salvarProdutosBAO(ModelProdutos pModelProdutos) {

        try {
            this.conectar();
            return this.insertSQL("INSERT INTO produto ("
                    + "s_nome_produto,"
                    + "f_valor_produto,"
                    + "f_estoque_produto"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getNomeProd() + "',"
                    + "'" + pModelProdutos.getValorProd() + "',"
                    + "'" + pModelProdutos.getQtEstoque() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();

        }

    }

    /**
     * excluir prod banco
     *
     * @param pCodProduto
     * @return boolean
     */
    public boolean excluirProdutoBAO(int pCodProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM produto WHERE i_cod_produto = '" + pCodProduto + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();

        }
    }

    /**
     * alterar prod banco
     *
     * @param pModelProdutos
     * @return boolean
     */
    public boolean alterarProdutoBAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE produto SET "
                    + "s_nome_produto = '" + pModelProdutos.getNomeProd() + "',"
                    + "f_valor_produto = '" + pModelProdutos.getValorProd() + "',"
                    + "f_estoque_produto = '" + pModelProdutos.getQtEstoque() + "'"
                    + " WHERE i_cod_produto = '" + pModelProdutos.getCodProduto() + "'"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();

        }

    }

    public ModelProdutos retornarProdutoBAO(int pCodProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "i_cod_produto, "
                    + "s_nome_produto,"
                    + "f_valor_produto,"
                    + "f_estoque_produto "
                    + "FROM produto WHERE i_cod_produto = '" + pCodProduto + "';");
            while (this.getResultSet().next()) {
                modelProdutos.setCodProduto(this.getResultSet().getInt(1));
                modelProdutos.setNomeProd(this.getResultSet().getString(2));
                modelProdutos.setValorProd(this.getResultSet().getFloat(3));
                modelProdutos.setQtEstoque(this.getResultSet().getInt(4));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    public ModelProdutos retornarProdutosBAO(String pNomeProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "i_cod_produto, "
                    + "s_nome_produto,"
                    + "f_valor_produto,"
                    + "f_estoque_produto "
                    + "FROM produto WHERE i_cod_produto = '" + pNomeProduto + "';");
            while (this.getResultSet().next()) {
                modelProdutos.setCodProduto(this.getResultSet().getInt(1));
                modelProdutos.setNomeProd(this.getResultSet().getString(2));
                modelProdutos.setValorProd(this.getResultSet().getFloat(3));
                modelProdutos.setQtEstoque(this.getResultSet().getInt(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    public ArrayList<ModelProdutos> retornarListaProdutosBAO() {
        ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "i_cod_produto, "
                    + "s_nome_produto,"
                    + "f_valor_produto,"
                    + "f_estoque_produto "
                    + "FROM produto;");

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCodProduto(this.getResultSet().getInt(1));
                modelProdutos.setNomeProd(this.getResultSet().getString(2));
                modelProdutos.setValorProd(this.getResultSet().getFloat(3));
                modelProdutos.setQtEstoque(this.getResultSet().getInt(4));
                listaModelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProdutos;
    }

};
