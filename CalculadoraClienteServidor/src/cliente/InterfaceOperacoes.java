/*
 * Aluno: Lucas Batista de Avelar
 * Turma: ENG 07 TARDE
 * Disciplina: Sistemas Distribuidos
 *
 * Atividade Prática 25-03-2020
 */
package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author lucas
 */
public interface InterfaceOperacoes extends Remote{
    public double somar (double a, double b) throws RemoteException;
    public double subtrair (double a, double b) throws RemoteException;
    public double multiplicar (double a, double b) throws RemoteException;
    public double dividir (double a, double b) throws RemoteException;
       
}
