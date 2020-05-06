/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LojaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class LojaDAO {
  public static void adicionar(LojaBean loja){
        
        String sql = "INSERT INTO loja (cnpj, nome, endereco) VALUES (?, ?, ?)";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, loja.getCnpj());
            stmt.setString(2, loja.getNome());
            stmt.setString(3, loja.getEndereco());
            
            stmt.execute();
        }catch(Exception e){
            System.err.println("Erro no Adicionar Endereco: "+e.toString());
        }    
    }
    
    public static ArrayList<LojaBean> listar(){
        
        ArrayList<LojaBean> lojas = new ArrayList<>();
        
        String sql = "SELECT * FROM loja";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet registro = stmt.executeQuery();
            
            while(registro.next()){
               
                LojaBean temporario = new LojaBean();
                temporario.setNome(registro.getString("nome"));
                temporario.setCnpj(registro.getInt("cnpj"));
                temporario.setEndereco(registro.getString("endereco"));               
                lojas.add(temporario);
            }
            
            return lojas;
            
        
        }catch(Exception e){
            System.err.println("Erro no Listar Loja: "+e.toString());
        } 
        
        return null;
    }      
    
    public void atualizar(){}
    public void excluir(){}  
}
