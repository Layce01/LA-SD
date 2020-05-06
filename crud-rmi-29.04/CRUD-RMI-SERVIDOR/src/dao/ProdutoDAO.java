package dao;

import bean.ProdutoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
    
    public static void adicionar(ProdutoBean produto){
        
        String sql = "INSERT INTO produto (descricao, preco, quantidade) VALUES (?, ?, ?)";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.execute();
        }catch(Exception e){
            System.err.println("Erro no Adicionar Produto: "+e.toString());
        }    
    }
    
    public static ArrayList<ProdutoBean> listar(){
        
        ArrayList<ProdutoBean> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM produto";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet registro = stmt.executeQuery();
            
            while(registro.next()){
               
                ProdutoBean temporario = new ProdutoBean();
                temporario.setDescricao(registro.getString("descricao"));
                temporario.setPreco(registro.getDouble("preco"));
                temporario.setQuantidade(registro.getInt("quantidade"));               
                produtos.add(temporario);
            }
            
            return produtos;
            
        
        }catch(Exception e){
            System.err.println("Erro no Listar Produto: "+e.toString());
        } 
        
        return null;
    }      
    
    public void atualizar(){}
    public void excluir(){}
}
