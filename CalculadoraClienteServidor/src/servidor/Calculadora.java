/*
 * Aluno: Lucas Batista de Avelar
 * Turma: ENG 07 TARDE
 * Disciplina: Sistemas Distribuidos
 *
 * Atividade Prática 25-03-2020
 */
package servidor;

import cliente.InterfaceOperacoes;
import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author lucas
 */
public class Calculadora extends UnicastRemoteObject implements InterfaceOperacoes{
    
    public Calculadora() throws RemoteException{
        System.out.println("Servidor instanciado...");
    }
    @Override
    public double somar (double a, double b) throws RemoteException{
        return a+b;
    }
     @Override
     public double subtrair(double a, double b) throws RemoteException{
        return a-b;
    }
     @Override
     public double multiplicar (double a, double b) throws RemoteException{
        return a*b;
    }
     @Override
     public double dividir (double a, double b) throws RemoteException{
        return a/b;
    }
    
}
