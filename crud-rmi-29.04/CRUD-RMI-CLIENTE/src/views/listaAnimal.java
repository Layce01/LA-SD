/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceAnimal;
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
public class listaAnimal extends JPanel{
    
    public listaAnimal() throws NotBoundException, MalformedURLException{
        try{
           InterfaceAnimal animalRemoto = (InterfaceAnimal) Naming.lookup("rmi://192.168.0.120:1099/Animal");     
           
           ArrayList<InterfaceAnimal> animais = animalRemoto.listar();
           
           for(InterfaceAnimal animal: animais){
               add(new JLabel(animal.getEspecie()+animal.getTipo()+animal.getDescricao()));
           }
            
        }catch(RemoteException re){
            
        }
    }
}
    

