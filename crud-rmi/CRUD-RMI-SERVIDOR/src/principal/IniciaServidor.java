package principal;

import java.rmi.registry.LocateRegistry;
import classes.Produto;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class IniciaServidor {
    
    public static void main(String[] args) {

        try {
            System.out.println("Iniciando Servidor");
            LocateRegistry.createRegistry(1099);

            Produto objetoProduto = new Produto();
            Naming.rebind("rmi://192.168.1.130:1099/Produto", objetoProduto);

        } catch (RemoteException re) {
            System.out.println("Erro remoto: " + re.toString());
        } catch (Exception e) {
            System.out.println("Erro local: " + e.toString());
        }

    }

}
