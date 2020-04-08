/*
 * Aluno: Lucas Batista de Avelar
 * Turma: ENG 07 TARDE
 * Disciplina: Sistemas Distribuidos
 *
 * Atividade Prática 25-03-2020
 */
package servidor;



import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author lucas
 */
public class IniciarServidor {
    
    public static void main(String[] args) {
        try
        {
            System.out.println("Iniciando servidor...");
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://127.0.0.1:1099/CalculadoraRMI", new Calculadora());
        } catch (RemoteException re) {
            System.out.println("Erro Remoto: "+re.toString());
        } catch (Exception e) {
            System.out.println("Erro Local: "+e.toString());
        }
    }
}
