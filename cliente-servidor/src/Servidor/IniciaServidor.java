/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class IniciaServidor {

    public static void main(String[] args) {
        try {

            System.out.println("Iniciando Servidor");
            LocateRegistry.createRegistry(1099);

            Produto objetoProduto = new Produto();
            Naming.rebind("rmi://localhost:1099/produto", objetoProduto);

        } catch (RemoteException re) {
            System.out.println("Erro remoto: " + re.toString());
        } catch (Exception e) {
            System.out.println("Erro local: " + e.toString());
        }
    }

}
