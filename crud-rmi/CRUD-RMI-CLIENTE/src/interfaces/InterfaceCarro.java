/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author lucas
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCarro extends Remote{
    
public String getModelo()throws RemoteException;    
public void setModelo(String modelo)throws RemoteException;
public String getPlaca()throws RemoteException;
public void setPlaca(String placa)throws RemoteException;        
public String getCor()throws RemoteException;        
public void setCor(String cor)throws RemoteException;        
public void adicionar() throws RemoteException;       
}
