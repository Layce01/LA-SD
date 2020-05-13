/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceFilme;
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
public class adicionarFilme extends JPanel implements ActionListener{
    JTextField campo_nome;
    JTextField campo_genero;
    JTextField campo_classificacao;
    JButton botao_salvar;
            
    public adicionarFilme(){
        JLabel label_nome = new JLabel("Nome:");
        campo_nome = new JTextField(20);
        JLabel label_genero = new JLabel("Genero:");
        campo_genero = new JTextField(20);
        JLabel label_classificacao = new JLabel("Classificacao:");
        campo_classificacao = new JTextField(20);
        
        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);
        
        add(label_nome);
        add(campo_nome);
        add(label_genero);
        add(campo_genero);
        add(label_classificacao);
        add(campo_classificacao);
        add(botao_salvar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {       
            
            String string_nome = campo_nome.getText();
            String string_genero = campo_genero.getText();
            String string_classificacao = campo_classificacao.getText();
                       
            String nome = string_nome;
            String genero = string_genero;
            int classificacao = Integer.parseInt(string_classificacao);
            
        try{    
            InterfaceFilme filmeRemoto = (InterfaceFilme) Naming.lookup("rmi://192.168.0.120:1099/Filme");            
            filmeRemoto.setNome(nome);
            filmeRemoto.setGenero(genero);
            filmeRemoto.setClassificacao(classificacao);
            
            filmeRemoto.adicionar();
                      
        }catch(RemoteException re){
            JOptionPane.showMessageDialog(null, "Erro Remoto:"+re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
