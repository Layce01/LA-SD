/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AnimalDAO;
import interfaces.InterfaceAnimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class AnimalBean extends UnicastRemoteObject implements InterfaceAnimal{
    
    private String especie;
    private String tipo;
    private String descricao;
    
    public AnimalBean() throws RemoteException {
        System.out.println("a Classe animal está disponivel remotamente...");
    }

    @Override
    public String getEspecie() {
        return especie;
    }

    @Override
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public void adicionar(){
        AnimalDAO.adicionar(this);
    }

    @Override
    public ArrayList<AnimalBean> listar() throws RemoteException {
       return AnimalDAO.listar();
    }
    
    
    
}
