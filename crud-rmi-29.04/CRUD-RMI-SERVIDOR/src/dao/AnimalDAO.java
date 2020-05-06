/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AnimalBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class AnimalDAO {
    public static void adicionar(AnimalBean animal){
        
        String sql = "INSERT INTO animal (especie, tipo, descricao) VALUES (?, ?, ?)";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, animal.getEspecie());
            stmt.setString(2, animal.getTipo());
            stmt.setString(3, animal.getDescricao());
           
            stmt.execute();
        }catch(Exception e){
            System.err.println("Erro no Adicionar Animal: "+e.toString());
        }    
    }
    
    public static ArrayList<AnimalBean> listar(){
        
        ArrayList<AnimalBean> animais = new ArrayList<>();
        
        String sql = "SELECT * FROM animal";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet registro = stmt.executeQuery();
            
            while(registro.next()){
               
                AnimalBean temporario = new AnimalBean();
                temporario.setEspecie(registro.getString("especie"));
                temporario.setTipo(registro.getString("tipo"));
                temporario.setDescricao(registro.getString("descricao"));
                              
                animais.add(temporario);
            }
            
            return animais;
            
        
        }catch(Exception e){
            System.err.println("Erro no Listar Animais: "+e.toString());
        } 
        
        return null;
    }      
    
    public void atualizar(){}
    public void excluir(){}
}
