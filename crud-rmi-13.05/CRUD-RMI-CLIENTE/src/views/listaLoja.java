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
public class listaLoja extends JPanel{
    
   private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    
    private static JTable tabela;
    private String[] colunas = {"CNPJ", "NOME", "ENDERECO"};
    private Object[][] dados;    
    private static DefaultTableModel modelo ;
    
    
    public listaLoja() throws NotBoundException, MalformedURLException{
        
        modelo = new DefaultTableModel(dados, colunas);
        
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        
        btnAdicionar.addActionListener(new BotaoAdicionarListener());
        btnEditar.addActionListener(new BotaoEditarListener());
        btnExcluir.addActionListener(new BotaoExcluirListener());
        
        
        
        try{
              InterfaceLoja lojaRemoto = (InterfaceLoja) Naming.lookup("rmi://192.168.0.120:1099/Loja");  
           
           tabela = new JTable(modelo);
           
           ArrayList<InterfaceLoja> lojas = lojaRemoto.listar();
           
           for(InterfaceLoja loja: lojas){
             String cnpj = Integer.toString(loja.getCnpj());
             String nome = loja.getNome();
             String endereco = loja.getEndereco();
             
             
             String[] registro = new String[]{cnpj, nome, endereco};   
               
               
             modelo.addRow(registro);             
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
                  centro.add( new adicionarLoja());
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
                    int cnpjLoja = Integer.parseInt(tabela.getValueAt(registroSelecionado, 0).toString());
                    String nomeLoja = tabela.getValueAt(registroSelecionado, 1).toString();
                    
                    InterfaceLoja lojaRemotoExcluir = (InterfaceLoja) Naming.lookup("rmi://192.168.0.120:1099/Loja");
                    
                    lojaRemotoExcluir.excluir(cnpjLoja);
                    modelo.removeRow(registroSelecionado);
                    
                    
                    JOptionPane.showMessageDialog(null, "o Registro "+nomeLoja+" foi  excluido");
                } catch (RemoteException ex) {
                    
                } catch (NotBoundException ex) {
                    Logger.getLogger(listaLoja.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(listaLoja.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Registro");
            }
            
            
        
        }
    }

    
}