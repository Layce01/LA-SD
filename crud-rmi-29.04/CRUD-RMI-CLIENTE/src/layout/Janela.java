/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.adicionarProduto;
import views.listaProduto;

public class Janela extends JFrame{    
    public JPanel menuTopo = new JPanel();  
    public JPanel centro = new JPanel(); 
    
    public GridLayout layoutTopo = new GridLayout();
    public BorderLayout layoutJanela = new BorderLayout();   
    
    public JButton botaoAdicionar = new JButton("Adicionar");
    public JButton botaoListar = new JButton("Listar");
    
  public Janela(){
      botaoAdicionar.addActionListener( new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             centro.removeAll();
             centro.add( new adicionarProduto());
             centro.repaint();
             centro.validate();
             
          }
      });
      
      botaoListar.addActionListener( new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              try {
                  centro.removeAll();
                  centro.add( new listaProduto());
                  centro.repaint();
                  centro.validate();
              } catch (NotBoundException ex) {
                  
              } catch (MalformedURLException ex) {
                 
              }
          }
      });
      
      menuTopo.setLayout(layoutTopo);
      menuTopo.add(botaoAdicionar);
      menuTopo.add(botaoListar);
            
      setLayout(layoutJanela);
      add(menuTopo, BorderLayout.NORTH);
       
      add(centro, BorderLayout.CENTER);
      setSize(280, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
  }  
}
