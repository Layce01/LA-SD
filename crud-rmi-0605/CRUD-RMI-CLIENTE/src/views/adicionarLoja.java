/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceLoja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lucas
 */
public class adicionarLoja extends JPanel implements ActionListener{
    JTextField campo_nome;
    JTextField campo_endereco;
    JTextField campo_cnpj;
    JButton botao_salvar;
            
    public adicionarLoja(){
        JLabel label_nome = new JLabel("Nome:");
        campo_nome = new JTextField(20);
        JLabel label_endereco = new JLabel("Endereco:");
        campo_endereco = new JTextField(20);
        JLabel label_cnpj = new JLabel("CNPJ:");
        campo_cnpj = new JTextField(20);
        
        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);
        
        add(label_nome);
        add(campo_nome);
        add(label_endereco);
        add(campo_endereco);
        add(label_cnpj);
        add(campo_cnpj);
        add(botao_salvar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {       
            
            String string_nome = campo_nome.getText();
            String string_endereco = campo_endereco.getText();
            String string_cnpj = campo_cnpj.getText();
                       
            String nome = string_nome;
            String endereco = string_endereco;
            int cnpj = Integer.parseInt(string_cnpj);
            
        try{    
            InterfaceLoja lojaRemoto = (InterfaceLoja) Naming.lookup("rmi://192.168.0.120:1099/Loja");            
            lojaRemoto.setNome(nome);
            lojaRemoto.setEndereco(endereco);
            lojaRemoto.setCnpj(cnpj);
            
            lojaRemoto.adicionar();
                      
        }catch(RemoteException re){
            JOptionPane.showMessageDialog(null, "Erro Remoto:"+re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
