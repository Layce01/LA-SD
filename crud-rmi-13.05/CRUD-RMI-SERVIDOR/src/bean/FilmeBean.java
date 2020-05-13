/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FilmeDAO;
import interfaces.InterfaceFilme;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class FilmeBean extends UnicastRemoteObject implements InterfaceFilme{
    private int id;
    private String nome;
    private String genero;
    private int classificacao;
    
     public FilmeBean() throws RemoteException {
        System.out.println("a Classe filme está disponivel remotamente...");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public void adicionar(){
        FilmeDAO.adicionar(this);
    }
    
    @Override
    public void excluir(int id){
        FilmeDAO.excluir(id);
    }

    @Override
    public ArrayList<FilmeBean> listar() throws RemoteException {
       return FilmeDAO.listar();
    }
     
}
