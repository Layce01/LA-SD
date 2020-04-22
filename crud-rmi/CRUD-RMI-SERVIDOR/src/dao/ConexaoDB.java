/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lucas
 */
public class ConexaoDB {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/crud_rmi?useTimezone=true&serverTimezone=UTC";
    
    public static Connection retornaConexao() throws Exception{
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return connection;
        }catch(Exception e){
            System.out.println("Error:"+e.toString());
        }
        return null;
    }
}
