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

public interface InterfaceLoja extends Remote{
    
public String getNome()throws RemoteException;
public void setNome(String nome)throws RemoteException;
public int getCnpj()throws RemoteException;        
public void setCnpj(int cnpj)throws RemoteException;        
public String getEndereco()throws RemoteException;        
public void setEndereco(String endereco)throws RemoteException;        
        
}
