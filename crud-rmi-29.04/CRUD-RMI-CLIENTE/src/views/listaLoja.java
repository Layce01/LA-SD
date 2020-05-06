/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceLoja;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lucas
 */
public class listaLoja extends JPanel{
    
   public listaLoja() throws NotBoundException, MalformedURLException{
        try{
           InterfaceLoja lojaRemoto = (InterfaceLoja) Naming.lookup("rmi://192.168.0.120:1099/Loja");     
           
           ArrayList<InterfaceLoja> lojas = lojaRemoto.listar();
           
           for(InterfaceLoja loja: lojas){
               add(new JLabel(loja.getNome()+loja.getEndereco()+loja.getCnpj()));
           }
            
        }catch(RemoteException re){
            
        }
    } 
}
