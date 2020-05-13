/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceCarro;
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
public class adicionarCarro extends JPanel implements ActionListener{
    
    JTextField campo_modelo;
    JTextField campo_placa;
    JTextField campo_cor;
    JButton botao_salvar;
    
    public adicionarCarro(){
        JLabel label_modelo = new JLabel("Modelo:");
        campo_modelo = new JTextField(20);
        JLabel label_placa = new JLabel("Placa:");
        campo_placa = new JTextField(20);
        JLabel label_cor = new JLabel("Cor:");
        campo_cor = new JTextField(20);
        
        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);
        
        add(label_modelo);
        add(campo_modelo);
        add(label_placa);
        add(campo_placa);
        add(label_cor);
        add(campo_cor);
        add(botao_salvar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {       
            
            String string_modelo = campo_modelo.getText();
            String string_placa = campo_placa.getText();
            String string_cor = campo_cor.getText();
                       
            String modelo = string_modelo;
            String placa = string_placa;
            String cor = string_cor;
            
            
        try{    
            InterfaceCarro carroRemoto = (InterfaceCarro) Naming.lookup("rmi://192.168.0.120:1099/Carro");            
            carroRemoto.setModelo(modelo);
            carroRemoto.setPlaca(placa);
            carroRemoto.setCor(cor);
            
            carroRemoto.adicionar();
                      
        }catch(RemoteException re){
            JOptionPane.showMessageDialog(null, "Erro Remoto:"+re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
