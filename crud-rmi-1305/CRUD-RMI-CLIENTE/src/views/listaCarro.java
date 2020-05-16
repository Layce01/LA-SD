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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static layout.Janela.centro;

/**
 *
 * @author lucas
 */
public class listaCarro extends JPanel{
    
    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    
    private static JTable tabela;
    private String[] colunas = {"PLACA", "MODELO", "COR"};
    private Object[][] dados;    
    private static DefaultTableModel model ;
    
    
    public listaCarro() throws NotBoundException, MalformedURLException{
        
        model = new DefaultTableModel(dados, colunas);
        
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        
        btnAdicionar.addActionListener(new BotaoAdicionarListener());
        btnEditar.addActionListener(new BotaoEditarListener());
        btnExcluir.addActionListener(new BotaoExcluirListener());
        
        
        
        try{
              InterfaceCarro carroRemoto = (InterfaceCarro) Naming.lookup("rmi://192.168.0.120:1099/Carro");  
           
           tabela = new JTable(model);
           
           ArrayList<InterfaceCarro> carros = carroRemoto.listar();
           
           for(InterfaceCarro carro: carros){
             String placa = carro.getPlaca();
             String modelo = carro.getModelo();
             String cor = carro.getCor();
             
             
             
             String[] registro = new String[]{placa, modelo, cor};   
             
             //String[] registro = new String[]{"1", "1", "11", "1222"};   
               
             model.addRow(registro);             
           }
            
           add(tabela);
           
           add(btnAdicionar);
           add(btnEditar);
           add(btnExcluir);
        }catch(RemoteException re){
            
        }
    }

    
    private static class BotaoAdicionarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                  centro.removeAll();
                  centro.add( new adicionarCarro());
                  centro.repaint();
                  centro.validate();
        }
    }

    private static class BotaoEditarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {}
    }
    
    private static class BotaoExcluirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int registroSelecionado = tabela.getSelectedRow();
            if(registroSelecionado >= 0){            
                try {
                    String placaCarro = tabela.getValueAt(registroSelecionado, 0).toString();
                    String modeloCarro = tabela.getValueAt(registroSelecionado, 1).toString();
                    
                    InterfaceCarro carroRemotoExcluir = (InterfaceCarro) Naming.lookup("rmi://192.168.0.120:1099/Carro");
                    
                    carroRemotoExcluir.excluir(placaCarro);
                    model.removeRow(registroSelecionado);
                    
                    
                    JOptionPane.showMessageDialog(null, "o Registro "+modeloCarro+" foi  excluido");
                } catch (RemoteException ex) {
                    
                } catch (NotBoundException ex) {
                    Logger.getLogger(listaCarro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(listaCarro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Registro");
            }
            
            
        
        }
    }
    }
