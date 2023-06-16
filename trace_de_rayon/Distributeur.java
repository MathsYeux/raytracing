import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Distributeur implements ServiceDistributeur {
    List<Noeud> nodes;


    public Distributeur() {
        this.nodes = new ArrayList<>();
    }

    public void enregistrerClient(Noeud c) throws RemoteException {
        nodes.add(c);
    }

    public List<Noeud> demanderNeuds() throws RemoteException {
        return nodes;
    }
}
