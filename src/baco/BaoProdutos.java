/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baco;
import coneq.ConexaoMySql;
import model.ModelProdutos;

/**
 *cadastrar produto banco
 * @author Lucas
 */
public class BaoProdutos extends ConexaoMySql{
    public int salvarProdutosBao(ModelProdutos pModelProdutos){
        
        try{
            this.conectar();
            return this.insertSQL("INSERT INTO produto ("
                    + "i_cod_produto, "
                    + "s_nome_produto,"
                    + "f_valor_produto,"
                    + "f_estoque_produto,"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getNomeProd() + "',"
                    + "'" + pModelProdutos.getValorProd() + "',"
                    + "'" + pModelProdutos.getQtEstoque() + "',"
                    
            );
                    
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        
        }
    
    
    }
    /**
     * excluir prod banco
     * @param pCodProduto
     * @return boolean
     */
    public boolean excluirProdutoBAO(int pCodProduto){
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM produto WHERE i_cod_produto = '" + pCodProduto + "'"
            
            
            );
        } catch(Exception e){
            e.printStackTrace();
            return false;                    
        }finally{
            this.fecharConexao();
        
        }
    }
    
    /**
     * alterar prod banco
     * @param pModelProdutos
     * @return boolean
     */
    public boolean alterarProdutoBAO(ModelProdutos pModelProdutos){
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE produto SET "
                            + "s_nome_produto = '"+pModelProdutos.getNomeProd()+"',"
                            + "f_valor_produto = '"+pModelProdutos.getValorProd()+"',"
                            + "f_estoque_produto = '"+pModelProdutos.getQtEstoque()+"',"
                            + "WHERE i_cod_produto = '"+pModelProdutos.getCodProduto()+"'"
            
            );      
            
    }catch(Exception e){
        e.printStackTrace();
        return false;
    }finally{
        this.fecharConexao();
        
        }


    }
    
    public ModelProdutos();


}
    
