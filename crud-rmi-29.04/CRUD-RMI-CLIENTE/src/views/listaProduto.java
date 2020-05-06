/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceProduto;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lucas
 */
public class listaProduto extends JPanel {
    
    public listaProduto() throws NotBoundException, MalformedURLException{
        try{
           InterfaceProduto produtoRemoto = (InterfaceProduto) Naming.lookup("rmi://192.168.0.120:1099/Produto");     
           
           ArrayList<InterfaceProduto> produtos = produtoRemoto.listar();
           
           for(InterfaceProduto produto: produtos){
               add(new JLabel(produto.getDescricao()+" - "+produto.getQuantidade()));
           }
            
        }catch(RemoteException re){
            
        }
    }
}
