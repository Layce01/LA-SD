package classes;

import dao.AnimalDAO;
import interfaces.InterfaceAnimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Animal extends UnicastRemoteObject implements InterfaceAnimal{
    
    public String especie;
    public String descricao;
    public String tipo;
    
    public Animal() throws RemoteException{
        System.out.println("A classe Animal está disponível remotamente");
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
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    public void adicionar(){
        AnimalDAO.insert(this);
    }
    
    
}
