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

public interface InterfaceAnimal extends Remote{
    
    public String getEspecie() throws RemoteException;
    public String getDescricao() throws RemoteException;
    public String getTipo() throws RemoteException;
    public void setEspecie(String especie) throws RemoteException;
    public void setDescricao(String descricao )throws RemoteException;
    public void setTipo(String tipo) throws RemoteException;
            }
