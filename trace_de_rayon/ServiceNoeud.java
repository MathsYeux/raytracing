import raytracer.Image;
import raytracer.Scene;

import java.io.Serializable;

public interface ServiceNoeud extends Serializable, java.rmi.Remote {

  public Image compute(Scene s, int x0, int y0, int l, int h) throws java.rmi.RemoteException;
}
