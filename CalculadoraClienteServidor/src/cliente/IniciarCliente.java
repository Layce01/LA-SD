/*
 * Aluno: Lucas Batista de Avelar
 * Turma: ENG 07 TARDE
 * Disciplina: Sistemas Distribuidos
 *
 * Atividade Prática 25-03-2020
 */
package cliente;

import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class IniciarCliente {
    public static void main(String[] args) {
        try{
            InterfaceOperacoes c = (InterfaceOperacoes) Naming.lookup( "rmi://127.0.0.1:1099/CalculadoraRMI");
            
            String numero1=JOptionPane.showInputDialog(null, "Entre com o primeiro numero", "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
            String numero2=JOptionPane.showInputDialog(null, "Entre com o primeiro numero", "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
       
            double n1 = Double.parseDouble(numero1);
            double n2 = Double.parseDouble(numero2);
            
            Object[] operacoes = {"somar","subtrair","multiplicar","dividir"};
            Object selecionado = JOptionPane.showInputDialog(null, "Escolha a Operação", "Operação", JOptionPane.INFORMATION_MESSAGE, null,operacoes, operacoes[0]);
       
            if (selecionado == "somar"){
                JOptionPane.showMessageDialog(null, " o resultado é "+c.somar(n1,n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            if (selecionado == "subtrair"){
                JOptionPane.showMessageDialog(null, " o resultado é "+c.subtrair(n1,n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            if (selecionado == "multiplicar"){
                JOptionPane.showMessageDialog(null, " o resultado é "+c.multiplicar(n1,n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            if (selecionado == "dividir"){
                JOptionPane.showMessageDialog(null, " o resultado é "+c.dividir(n1,n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
        catch(RemoteException re){ JOptionPane.showMessageDialog(null, "Erro remoto: "+re.toString(), "Erro remoto", JOptionPane.WARNING_MESSAGE);}
        catch(Exception e){ JOptionPane.showMessageDialog(null, "Erro local: "+e.toString(), "Erro local", JOptionPane.WARNING_MESSAGE);}
    }
}
