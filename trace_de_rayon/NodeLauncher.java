import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NodeLauncher {

  public static void main(String[] args) {
    int port = 1099;
    String host = "localhost";
    if(args.length > 0) host = args[0];
    if(args.length > 1) port = Integer.parseInt(args[1]);
    Noeud n = new Noeud();

    Registry registry = null;
    try {
      registry = LocateRegistry.getRegistry(host, port);
    } catch (Exception e) {
      throw new RuntimeException("Erreur ici : " + e.getMessage());
    }

    try {
      ServiceDistributeur d = (ServiceDistributeur) registry.lookup("distributeur");
      d.enregistrerClient(n);
    } catch (Exception e) {
        throw new RuntimeException("Erreur la : " + e.getMessage());
    }
  }
}
