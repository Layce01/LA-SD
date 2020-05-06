/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import classes.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lucas
 */
public class FilmeDAO {
    public void insert(){
    String sql ="INSERT INTO filme (nome, genero, classificacao) VALUES (?,?,?)";
        
        try {
            Connection conexao= ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql); 
            stmt.setString(1, filme.getNome());
            stmt.setString(2,filme.getGenero());
            stmt.setInt(3, filme.getClassificacao());
            
            stmt.execute();
            
        }catch(Exception e){
            System.out.println("Erro na função Insert: "+e.toString());
        }}
    public void update(){}
    public void delete(){}
    public void select(){}
}
