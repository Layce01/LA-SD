/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceAnimal;
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
public class adicionarAnimal extends JPanel implements ActionListener{
    JTextField campo_especie;
    JTextField campo_tipo;
    JTextField campo_descricao;
    
    JButton botao_salvar;
    
    public adicionarAnimal(){
        JLabel label_especie = new JLabel("Epecie:");
        campo_especie = new JTextField(20);
        JLabel label_tipo = new JLabel("Tipo:");
        campo_tipo = new JTextField(20);
        JLabel label_descricao = new JLabel("Descricao:");
        campo_descricao = new JTextField(20);
        
        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);
        
        add(label_especie);
        add(campo_especie);
        add(label_tipo);
        add(campo_tipo);
        add(label_descricao);
        add(campo_descricao);
        add(botao_salvar);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {       
            
            String string_especie = campo_especie.getText();
            String string_tipo = campo_tipo.getText();
            String string_descricao = campo_descricao.getText();
                       
            String especie = string_especie;
            String tipo = string_tipo;
            String descricao = string_descricao;
            
            
        try{    
            InterfaceAnimal AnimalRemoto = (InterfaceAnimal) Naming.lookup("rmi://192.168.0.120:1099/Animal");            
            AnimalRemoto.setEspecie(especie);
            AnimalRemoto.setTipo(tipo);
            AnimalRemoto.setDescricao(descricao);
            
            
            AnimalRemoto.adicionar();
                      
        }catch(RemoteException re){
            JOptionPane.showMessageDialog(null, "Erro Remoto:"+re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
