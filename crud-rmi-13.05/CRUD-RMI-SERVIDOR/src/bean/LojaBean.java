/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.LojaDAO;
import interfaces.InterfaceLoja;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class LojaBean extends UnicastRemoteObject implements InterfaceLoja{
    private String nome;
    private String endereco;
    private int cnpj;
    
    public LojaBean() throws RemoteException {
        System.out.println("a Classe loja está disponivel remotamente...");
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
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
    public void adicionar(){
        LojaDAO.adicionar(this);
    }
    
    @Override
    public void excluir(int cnpj){
        LojaDAO.excluir(cnpj);
    }

    @Override
    public ArrayList<LojaBean> listar() throws RemoteException {
       return LojaDAO.listar();
    }
    
}
