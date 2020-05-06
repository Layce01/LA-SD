/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface InterfaceFilme {
    
    
    public void setNome(String nome) throws RemoteException;   
    public void setGenero(String genero) throws RemoteException;        
    public void setClassificacao(int classificacao) throws RemoteException;
    
    public String getNome() throws RemoteException;    
    public String getGenero() throws RemoteException;        
    public int getClassificacao() throws RemoteException;
    
      
    public void adicionar() throws RemoteException;

    public ArrayList<InterfaceFilme> listar() throws RemoteException;
}
