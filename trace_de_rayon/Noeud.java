import raytracer.Image;
import raytracer.Scene;

public class Noeud implements ServiceNoeud{

  public Image compute(Scene s, int x0, int y0, int l, int h) {
    return s.compute(x0, y0, l, h);
  }
}
