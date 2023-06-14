import raytracer.Disp;
import raytracer.Image;
import raytracer.Scene;

import java.rmi.RemoteException;

public class NotAThread extends Thread {

  ServiceNoeud noeud;
  int x0;
  int y0;
  int l;
  int h;
  Scene scene;
  Disp image;

  public NotAThread(ServiceNoeud n, Scene s, int x0, int y0, int l, int h, Disp i) {
    this.noeud = n;
    this.x0 = x0;
    this.y0 = y0;
    this.l = l;
    this.h = h;
    this.scene = s;
    this.image = i;
  }

  public void run() {
    try {
      Image im = noeud.compute(scene, x0, y0, l, h);
      image.setImage(im, x0, y0);
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }
  }
}
