/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceFilme;
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
public class listaFilme extends JPanel{
    
    public listaFilme() throws NotBoundException, MalformedURLException{
        try{
           InterfaceFilme filmeRemoto = (InterfaceFilme) Naming.lookup("rmi://192.168.0.120:1099/Filme");     
           
           ArrayList<InterfaceFilme> filmes = filmeRemoto.listar();
           
           for(InterfaceFilme filme: filmes){
               add(new JLabel(filme.getNome()+filme.getGenero()+filme.getClassificacao()));
           }
            
        }catch(RemoteException re){
            
        }
    }
}
