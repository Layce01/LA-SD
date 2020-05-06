/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.CarroBean;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface InterfaceCarro extends Remote{
    
    public void setModelo(String modelo) throws RemoteException;   
    public void setPlaca(String placa) throws RemoteException;   
    public void setCor(String cor) throws RemoteException;   
    
    
    public String getModelo() throws RemoteException;    
    public String getPlaca() throws RemoteException;    
    public String getCor() throws RemoteException;    
     
    public void adicionar() throws RemoteException;

    public ArrayList<CarroBean> listar() throws RemoteException;
}
