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
import interfaces.InterfaceCarro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarCarro extends JPanel implements ActionListener  {
    
    JTextField campo_modelo;
    JTextField campo_placa;
    JTextField campo_cor;

    JButton botao_salvar;

    public AdicionarCarro() {
        JLabel label_modelo = new JLabel("Modelo: ");
        campo_modelo = new JTextField(20);
        JLabel label_placa = new JLabel("Placa: ");
        campo_placa = new JTextField(20);
        JLabel label_cor = new JLabel("Cor: ");
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
    public void actionPerformed(ActionEvent ae) {

        String modelo = campo_modelo.getText();
        String placa = campo_placa.getText();
        String cor = campo_cor.getText();
        

        try {
            InterfaceCarro carroRemoto = (InterfaceCarro) Naming.lookup("rmi://192.168.1.130:1099/Carro");

            carroRemoto.setModelo(modelo);
            carroRemoto.setPlaca(placa);
            carroRemoto.setCor(cor);
            carroRemoto.adicionar();

            String texto_retorno = "\nModelo: " + carroRemoto.getModelo() + "\nPlaca: "
                    + carroRemoto.getPlaca() + "\nCor: " + carroRemoto.getCor();

            JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Carro", JOptionPane.INFORMATION_MESSAGE);
        } catch (RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro remoto: " + re.toString(), "Erro remoto",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro local: " + e.toString(), "Erro local",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

}

