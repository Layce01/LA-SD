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
public class listaAnimal extends JPanel{
    
    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    
    private static JTable tabela;
    private String[] colunas = {"ID", "ESPECIE", "TIPO", "DESCRICAO"};
    private Object[][] dados;    
    private static DefaultTableModel modelo ;
    
    
    public listaAnimal() throws NotBoundException, MalformedURLException{
        
        modelo = new DefaultTableModel(dados, colunas);
        
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        
        btnAdicionar.addActionListener(new BotaoAdicionarListener());
        btnEditar.addActionListener(new BotaoEditarListener());
        btnExcluir.addActionListener(new BotaoExcluirListener());
        
        
        
        try{
              InterfaceAnimal animalRemoto = (InterfaceAnimal) Naming.lookup("rmi://192.168.0.120:1099/Animal");  
           
           tabela = new JTable(modelo);
           
           ArrayList<InterfaceAnimal> animais = animalRemoto.listar();
           
           for(InterfaceAnimal animal: animais){
             String id = Integer.toString(animal.getId());
             String especie = animal.getEspecie();
             String tipo = animal.getTipo();
             String descricao = animal.getDescricao();
             
             
             String[] registro = new String[]{id, descricao, tipo, descricao};   
             
               
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
                  centro.add( new adicionarAnimal());
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
                    int idAnimal = Integer.parseInt(tabela.getValueAt(registroSelecionado, 0).toString());
                    String especieAnimal = tabela.getValueAt(registroSelecionado, 1).toString();
                    
                    InterfaceAnimal animalRemotoExcluir = (InterfaceAnimal) Naming.lookup("rmi://192.168.0.120:1099/Animal");
                    
                    animalRemotoExcluir.excluir(idAnimal);
                    modelo.removeRow(registroSelecionado);
                    
                    
                    JOptionPane.showMessageDialog(null, "o Registro "+especieAnimal+" foi  excluido");
                } catch (RemoteException ex) {
                    
                } catch (NotBoundException ex) {
                    Logger.getLogger(listaAnimal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(listaAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Registro");
            }
            
            
        
        }
    }

    
}
    

