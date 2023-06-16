import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceDistributeur extends Remote {
        void enregistrerClient(ServiceTableauBlanc c) throws RemoteException;

        void distribuerMessage(Dessin d) throws RemoteException;

}
