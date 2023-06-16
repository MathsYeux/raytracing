import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        int port = 1099;
        if(args.length > 0) port = Integer.parseInt(args[0]);

        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(port);
        } catch (Exception e) {
            System.out.println("Erreur ici : " + e.getMessage());
            System.exit(1);
        }

        ServiceDistributeur distributeur = null;
        try {
            distributeur = (ServiceDistributeur) UnicastRemoteObject.exportObject(new Distributeur(), 0);
        } catch (RemoteException e) {
            System.out.println("Erreur la : " + e.getMessage());
            System.exit(1);
        }

        System.out.println(distributeur);
        try {
            registry.rebind("tableauBlanc", distributeur);
        } catch (RemoteException e) {
            System.out.println("Erreur ailleurs : " + e.getMessage());
            System.exit(1);
        }catch (Exception e){
            System.out.println("test");
        }

    }
}
