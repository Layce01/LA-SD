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
import dao.CarroDAO;
import interfaces.InterfaceCarro;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Carro extends UnicastRemoteObject implements InterfaceCarro{
    
    public String modelo;
    public String placa;
    public String cor;
    
    public Carro() throws RemoteException {
        System.out.print("A classe carro está disponível remotamente.");
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getCor() {
        return cor;
    }

    @Override
    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public void adicionar(){
        CarroDAO.insert(this); 
    }
    
    
}
