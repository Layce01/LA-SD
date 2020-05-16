/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CarroDAO;
import interfaces.InterfaceCarro;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class CarroBean extends UnicastRemoteObject implements InterfaceCarro{
    private String modelo; 
    private String placa; 
    private String cor; 
    
    
    public CarroBean() throws RemoteException {
        System.out.println("a Classe carro está disponivel remotamente...");
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
        CarroDAO.adicionar(this);
    }
    
    @Override
    public void excluir(String placa){
        CarroDAO.excluir(placa);
    }

    @Override
    public ArrayList<CarroBean> listar() throws RemoteException {
       return CarroDAO.listar();
    }
    
    
}
