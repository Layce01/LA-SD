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

public interface InterfaceFilme extends Remote{
    
public String getGenero()throws RemoteException;
public void setGenero(String genero)throws RemoteException;        
public int getClassificacao()throws RemoteException;        
public void setClassificacao(int classificacao)throws RemoteException;  
public String getNome()throws RemoteException;
public void setNome(String nome)throws RemoteException;        
public void adicionar() throws RemoteException;        
}
