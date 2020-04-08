/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//**
 *
 * @author lucas
 */

package Servidor;





import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Produto extends UnicastRemoteObject implements InterfaceProduto {
    public String descricao;
    public double preco;
    public int quantidade;

    public Produto() throws RemoteException {
        System.out.println("A classe prodduto está disponivel remotamente.");
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int getQuantidade() {
        return this.quantidade;
    }

    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
