/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import interfaces.InterfaceAnimal;
import interfaces.InterfaceProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarAnimal extends JPanel implements ActionListener{
    
    JTextField campo_especie;
    JTextField campo_descricao;
    JTextField campo_tipo;
    
    JButton botao_salvar;
    

     public AdicionarAnimal() {
        JLabel label_especie = new JLabel("Especie: ");
        campo_especie = new JTextField(20);
        JLabel label_descricao = new JLabel("Descricao: ");
        campo_descricao = new JTextField(20);
        JLabel label_tipo = new JLabel("Tipo: ");
        campo_tipo = new JTextField(20);

        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);

        add(label_especie);
        add(campo_especie);
        add(label_descricao);
        add(campo_descricao);
        add(label_tipo);
        add(campo_tipo);

        add(botao_salvar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String especie = campo_especie.getText();
        String descricao = campo_descricao.getText();
        String tipo = campo_tipo.getText();
        

        try {
            InterfaceAnimal produtoRemoto = (InterfaceAnimal) Naming.lookup("rmi://192.168.1.130:1099/Animal");

            produtoRemoto.setDescricao(descricao);
            produtoRemoto.setEspecie(especie);
            produtoRemoto.setTipo(tipo);

            String texto_retorno = "\nEspécie: " + produtoRemoto.getEspecie() + "\nTipo: "
                    + produtoRemoto.getTipo() + "\nDescrição: " + produtoRemoto.getDescricao();

            JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Animal", JOptionPane.INFORMATION_MESSAGE);
        } catch (RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro remoto: " + re.toString(), "Erro remoto",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro local: " + e.toString(), "Erro local",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

}
