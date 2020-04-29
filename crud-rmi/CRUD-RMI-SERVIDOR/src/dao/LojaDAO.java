/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Loja;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lucas
 */
public class LojaDAO {
    public void insert(){
    String sql ="INSERT INTO loja (nome, cnpj, endereco) VALUES (?,?,?)";
        
        try {
            Connection conexao= ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql); 
            stmt.setString(1, loja.getNome());
            stmt.setInt(2,loja.getCnpj());
            stmt.setString(3, loja.getEndereco());
            
            stmt.execute();
            
        }catch(Exception e){
            System.out.println("Erro na função Insert: "+e.toString());
        }
    }
    public void update(){}
    public void delete(){}
    public void select(){}
}
