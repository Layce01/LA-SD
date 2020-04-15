/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import interfaces.InterfaceFilme;
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

public class AdicionarFilme extends JPanel implements ActionListener {
    
    JTextField campo_genero;
    JTextField campo_classificacao;
    JTextField campo_nome;
    
    JButton botao_salvar;

    public AdicionarFilme() {
        JLabel label_genero = new JLabel("Genero: ");
        campo_genero = new JTextField(20);
        JLabel label_classificacao = new JLabel("Classificação: ");
        campo_classificacao = new JTextField(20);
        JLabel label_nome = new JLabel("Nome: ");
        campo_nome = new JTextField(20);

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
    public void actionPerformed(ActionEvent ae) {

        String nome = campo_nome.getText();
        String genero = campo_genero.getText();
        String classificacao = campo_classificacao.getText();
        

        try {
            InterfaceFilme filmeRemoto = (InterfaceFilme) Naming.lookup("rmi://192.168.1.130:1099/Filme");

            filmeRemoto.setNome(nome);
            filmeRemoto.setGenero(genero);
            filmeRemoto.setClassificacao(classificacao);

            String texto_retorno = "\nNome: " + filmeRemoto.getNome() + "\nGenero: "
                    + filmeRemoto.getGenero() + "\nClassificação: " + filmeRemoto.getClassificacao();

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
