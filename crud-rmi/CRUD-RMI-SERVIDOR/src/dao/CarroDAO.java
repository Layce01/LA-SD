/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lucas
 */
public class CarroDAO {
    public void insert(){
    String sql ="INSERT INTO carro (modelo, placa, cor) VALUES (?,?,?)";
        
        try {
            Connection conexao= ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql); 
            stmt.setString(1, carro.getModelo);
            stmt.setString(2, carro.getPlaca());
            stmt.setString(3, carro.getCor());
            
            stmt.execute();
            
        }catch(Exception e){
            System.out.println("Erro na função Insert: "+e.toString());
        }
    }
    public void update(){}
    public void delete(){}
    public void select(){}
}
