/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Servidor.InterfaceProduto;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class IniciarCliente {
    public static void main(String[] args) {

                try {

                        InterfaceProduto produtoRemoto = (InterfaceProduto) Naming
                                        .lookup("rmi://localhost:1099/produto");

                        String string_descricao = JOptionPane.showInputDialog(null, "Qual produto quer cadastrar?",
                                        "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
                        String string_preco = JOptionPane.showInputDialog(null, "Qual o preço do produto?",
                                        "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
                        String string_quantidade = JOptionPane.showInputDialog(null, "Qual a quantidade no estoque?",
                                        "Entrada de dados", JOptionPane.QUESTION_MESSAGE);

                        produtoRemoto.setDescricao(string_descricao);
                        produtoRemoto.setPreco(Double.parseDouble(string_preco));
                        produtoRemoto.setQuantidade(Integer.parseInt(string_quantidade));

                        String texto_retorno = "Descrição: " + produtoRemoto.getDescricao() + "\nPreço: "
                                        + produtoRemoto.getPreco() + "\nQuantidade: " + produtoRemoto.getQuantidade();

                        JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Produto",
                                        JOptionPane.INFORMATION_MESSAGE);

                } catch (RemoteException re) {
                        JOptionPane.showMessageDialog(null, "Erro remoto: " + re.toString(), "Erro remoto",
                                        JOptionPane.WARNING_MESSAGE);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro local: " + e.toString(), "Erro local",
                                        JOptionPane.WARNING_MESSAGE);
                }

        }
}