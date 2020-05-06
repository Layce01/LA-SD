/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceCarro;
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
public class listaCarro extends JPanel{
    
    public listaCarro() throws NotBoundException, MalformedURLException{
        try{
           InterfaceCarro carroRemoto = (InterfaceCarro) Naming.lookup("rmi://192.168.0.120:1099/Carro");     
           
           ArrayList<InterfaceCarro> carros = carroRemoto.listar();
           
           for(InterfaceCarro carro: carros){
               add(new JLabel(carro.getModelo()+carro.getPLaca()+carro.getCor()));
           }
            
        }catch(RemoteException re){
            
        }
    }
}
