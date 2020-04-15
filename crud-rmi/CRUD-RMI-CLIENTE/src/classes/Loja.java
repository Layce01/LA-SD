/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author lucas
 */
import interfaces.InterfaceLoja;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Loja extends UnicastRemoteObject implements InterfaceLoja{
    
    public String nome;
    public int cnpj;
    public String endereco;
    
    public Loja() throws RemoteException {
        System.out.print("A classe loja está disponível remotamente.");
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getCnpj() {
        return cnpj;
    }

    @Override
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}
