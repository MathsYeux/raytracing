import java.rmi.Remote;

public interface ServiceDistributeur extends Remote {
    void enregistrerClient(Noeud c) throws java.rmi.RemoteException;

    java.util.List<Noeud> demanderNeuds() throws java.rmi.RemoteException;

    public void supprimerClient(Noeud c) throws java.rmi.RemoteException;
}
