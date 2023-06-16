import raytracer.Disp;
import raytracer.Image;
import raytracer.Scene;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Client {

  public static void main(String[] args) throws RemoteException {

    int port = 1099;
    String host = "localhost";
    int nbDecoupages = 10;
    if (args.length > 3) host = args[3];
    if (args.length > 4) port = Integer.parseInt(args[4]);
    if (args.length > 5) nbDecoupages = Integer.parseInt(args[5]);

    Registry registry = null;
    try {
      registry = LocateRegistry.getRegistry(host, port);
    } catch (Exception e) {
      System.out.println("Erreur ici : " + e.getMessage());
      System.exit(1);
    }

    ServiceDistributeur d = null;
    try {
      d = (ServiceDistributeur) registry.lookup("distributeur");
    } catch (Exception e) {
      System.out.println("Erreur la : " + e.getMessage());
      System.exit(1);
    }

    List<Noeud> noeuds = d.demanderNeuds();
    // Le fichier de description de la scène si pas fournie
    String fichier_description = "simple.txt";

    // largeur et hauteur par défaut de l'image à reconstruire
    int largeur = 512, hauteur = 512;

    if (args.length > 0) {
      fichier_description = args[0];
      if (args.length > 1) {
        largeur = Integer.parseInt(args[1]);
        if (args.length > 2)
          hauteur = Integer.parseInt(args[2]);
      }
    }
    // création d'une fenêtre
    Disp disp = new Disp("Raytracer", largeur, hauteur);

    // Initialisation d'une scène depuis le modèle
    Scene scene = new Scene(fichier_description, largeur, hauteur);

    int x0 = 0, y0 = 0;
    int l = largeur, h = hauteur;

    // Chronométrage du temps de calcul
    Instant debut = Instant.now();
    System.out.println("Calcul de l'image :\n - Coordonnées : " + x0 + "," + y0
            + "\n - Taille " + largeur + "x" + hauteur);

    int pas = largeur/10, n = 0;
    for (int i = 0; i < nbDecoupages; i++) {
      for (int j = 0; j < nbDecoupages; j++) {
        if (n == noeuds.size()) n = 0;
        try{
          NotAThread nt = new NotAThread(noeuds.get(n), scene, x0 + i * pas, y0 + j * pas, pas, pas, disp);
          nt.start();
        }catch (Exception e) {
          System.out.println("Un noeud ne répond plus");
          noeuds.remove(n);
        }
      }
    }
    Instant fin = Instant.now();

    long duree = Duration.between(debut, fin).toMillis();

    System.out.println("Image calculée en :" + duree + " ms");
  }
}
