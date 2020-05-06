/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author lucas
 */

import interfaces.InterfaceLoja;
import interfaces.InterfaceProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarLoja extends JPanel implements ActionListener{
    
    JTextField campo_nome;
    JTextField campo_cnpj;
    JTextField campo_endereco;

    JButton botao_salvar;

    public AdicionarLoja() {
        JLabel label_nome = new JLabel("Nome: ");
        campo_nome = new JTextField(20);
        JLabel label_cnpj = new JLabel("CNPJ: ");
        campo_cnpj = new JTextField(20);
        JLabel label_endereco = new JLabel("Endereco: ");
        campo_endereco = new JTextField(20);

        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);

        add(label_nome);
        add(campo_nome);
        add(label_cnpj);
        add(campo_cnpj);
        add(label_endereco);
        add(campo_endereco);

        add(botao_salvar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String nome = campo_nome.getText();
        String cnpj = campo_cnpj.getText();
        String endereco = campo_endereco.getText();
        

        try {
            InterfaceLoja lojaRemoto = (InterfaceLoja) Naming.lookup("rmi://192.168.1.130:1099/Loja");

            lojaRemoto.setNome(nome);
            lojaRemoto.setCnpj(cnpj);
            lojaRemoto.setEndereco(endereco);

            String texto_retorno = "\nNome: " + lojaRemoto.getCnpj() + "\nCnpj: "
                    + lojaRemoto.getCnpj() + "\nEndereco: " + lojaRemoto.getEndereco();

            JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Filme", JOptionPane.INFORMATION_MESSAGE);
        } catch (RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro remoto: " + re.toString(), "Erro remoto",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro local: " + e.toString(), "Erro local",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

}

