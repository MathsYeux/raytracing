import java.rmi.RemoteException;

public class DefnitlyNotAThread extends Thread{
    private ServiceTableauBlanc pierreLeVrai;
    private Dessin dessinDePierre;

    public DefnitlyNotAThread(ServiceTableauBlanc pierre, Dessin dessin){
        this.pierreLeVrai = pierre;
        this.dessinDePierre = dessin;
    }

    @Override
    public void run(){
        try {
            pierreLeVrai.afficherMessage(dessinDePierre);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
