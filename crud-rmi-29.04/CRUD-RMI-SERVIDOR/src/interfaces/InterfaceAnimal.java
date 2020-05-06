/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.AnimalBean;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface InterfaceAnimal extends Remote{
    public void setEspecie(String especie) throws RemoteException;   
    public void setTipo(String tipo) throws RemoteException;   
    public void setDescricao(String descricao) throws RemoteException;   
        
    public String getEspecie() throws RemoteException;    
    public String getTipo() throws RemoteException;    
    public String getDescricao() throws RemoteException;    
    
    
      
    public void adicionar() throws RemoteException;

    public ArrayList<AnimalBean> listar() throws RemoteException;
}
