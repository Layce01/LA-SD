/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.FilmeBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class FilmeDAO {
    public static void adicionar(FilmeBean filme){
        
        String sql = "INSERT INTO filme (nome, genero, classificacao) VALUES (?, ?, ?)";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getGenero());            
            stmt.setInt(3, filme.getClassificacao());
            stmt.execute();
        }catch(Exception e){
            System.err.println("Erro no Adicionar Flme: "+e.toString());
        }    
    }
    
    public static ArrayList<FilmeBean> listar(){
        
        ArrayList<FilmeBean> filmes = new ArrayList<>();
        
        String sql = "SELECT * FROM filme";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet registro = stmt.executeQuery();
            
            while(registro.next()){
               
                FilmeBean temporario = new FilmeBean();
                temporario.setNome(registro.getString("nome"));
                temporario.setGenero(registro.getString("genero"));                
                temporario.setClassificacao(registro.getInt("classificacao"));               
                filmes.add(temporario);
            }
            
            return filmes;
            
        
        }catch(Exception e){
            System.err.println("Erro no Listar Filme: "+e.toString());
        } 
        
        return null;
    }      
    
    
    public static void excluir(int id){
        String sql = "DELETE FROM filme WHERE id = ?";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            
        }catch(Exception e){
            System.err.println("Erro no Excluir Filme: "+e.toString());
        } 
        
        
    }
    public void atualizar(){}
}
