/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CarroBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class CarroDAO {
   public static void adicionar(CarroBean carro){
        
        String sql = "INSERT INTO carro (modelo, placa, cor) VALUES (?, ?, ?)";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getPlaca());
            stmt.setString(3, carro.getCor());
            
            stmt.execute();
        }catch(Exception e){
            System.err.println("Erro no Adicionar Cor: "+e.toString());
        }    
    }
    
    public static ArrayList<CarroBean> listar(){
        
        ArrayList<CarroBean> carros = new ArrayList<>();
        
        String sql = "SELECT * FROM carro";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet registro = stmt.executeQuery();
            
            while(registro.next()){
               
                CarroBean temporario = new CarroBean();
                temporario.setModelo(registro.getString("modelo"));
                temporario.setPlaca(registro.getString("placa"));
                temporario.setCor(registro.getString("cor"));
                               
                carros.add(temporario);
            }
            
            return carros;
            
        
        }catch(Exception e){
            System.err.println("Erro no Listar Carro: "+e.toString());
        } 
        
        return null;
    }      
    
    
    public static void excluir(String placa){
        String sql = "DELETE FROM carro WHERE placa = ?";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, placa);
            stmt.execute();
            
        }catch(Exception e){
            System.err.println("Erro no Excluir Produto: "+e.toString());
        } 
        
        
    }
    public void atualizar(){}
}
