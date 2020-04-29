/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lucas
 */
public class AnimalDAO {
    public void insert(Animal animal){
    String sql ="INSERT INTO animal (especie, descricao, tipo) VALUES (?,?,?)";
        
        try {
            Connection conexao= ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql); 
            stmt.setString(1, animal.getEspecie());
            stmt.setString(2,animal.getDescricao());
            stmt.setString(3,animal.getTipo());
            
            stmt.execute();
            
        }catch(Exception e){
            System.out.println("Erro na função Insert: "+e.toString());
        }
    }
    public void update(){}
    public void delete(){}
    public void select(){}
}
