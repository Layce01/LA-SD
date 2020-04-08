/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.rmi.RemoteException;

/**
 *
 * @author lucas
 */
public interface InterfaceProduto {
    
    public void setDescricao(String descricao) throws RemoteException;
    public void setPreco(double preco) throws RemoteException ;
    public void setQuantidade(int quantidade) throws RemoteException;
    public String getDescricao() throws RemoteException;
    public double getPreco() throws RemoteException;
    public int getQuantidade() throws RemoteException;

    
    
}
