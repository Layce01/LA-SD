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
import interfaces.InterfaceFilme;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Filme extends UnicastRemoteObject implements InterfaceFilme {
    
    public String genero;
    public int classificacao;
    public String nome;
    
    public Filme() throws RemoteException {
        System.out.print("A classe filme está disponível remotamente.");
    }

    @Override
    public String getGenero() {
        return genero;
    }

    @Override
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int getClassificacao() {
        return classificacao;
    }

    @Override
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
