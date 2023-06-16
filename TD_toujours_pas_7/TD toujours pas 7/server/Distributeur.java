import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Distributeur implements ServiceDistributeur {

    List<Dessin> dessins;
    List<ServiceTableauBlanc> clients;


    public Distributeur() {
        this.clients = new ArrayList<>();
        dessins = new ArrayList<>();
    }

    @Override
    public void enregistrerClient(ServiceTableauBlanc c) throws RemoteException {
        clients.add(c);
        for (Dessin d : dessins) {
            c.afficherMessage(d);
        }
    }

    @Override
    public void distribuerMessage(Dessin d) throws RemoteException {
        dessins.add(d);
        for (int i = 0; i < clients.size(); i++) {
            //c.afficherMessage(d);
            ServiceTableauBlanc c = clients.get(i);
            try{
                new DefnitlyNotAThread(c,d).start();
            }catch(RuntimeException e){
                clients.remove(c);
                System.out.print("ya un mossieur ilé parti");
            }
        }
    }
}
