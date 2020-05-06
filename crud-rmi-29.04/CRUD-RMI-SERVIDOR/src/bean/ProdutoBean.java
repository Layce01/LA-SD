
package bean;

import dao.ProdutoDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import interfaces.InterfaceProduto;
import java.util.ArrayList;

public class ProdutoBean extends UnicastRemoteObject implements InterfaceProduto{    
    private String descricao;
    private double preco;
    private int quantidade;
    
    public ProdutoBean() throws RemoteException {
        System.out.println("a Classe produto está disponivel remotamente...");
    }
    
    @Override
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    @Override
    public String getDescricao(){
        return this.descricao;
    }
    
    @Override
    public double getPreco(){
        return this.preco;
    }
    
    @Override
    public int getQuantidade(){
        return this.quantidade;
    }
    
    @Override
    public void adicionar(){
        ProdutoDAO.adicionar(this);
    }

    @Override
    public ArrayList<ProdutoBean> listar() throws RemoteException {
       return ProdutoDAO.listar();
    }
    
   
}
