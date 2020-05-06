/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.LojaBean;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface InterfaceLoja extends Remote{
    public void setNome(String descricao) throws RemoteException;       
    public void setCnpj(int cnpj) throws RemoteException;
    public void setEndereco(String endereco) throws RemoteException;
    
    public String getNome() throws RemoteException;       
    public int getCnpj() throws RemoteException;
    public String getEndereco() throws RemoteException;
    
      
    public void adicionar() throws RemoteException;

    public ArrayList<LojaBean> listar() throws RemoteException;
}
