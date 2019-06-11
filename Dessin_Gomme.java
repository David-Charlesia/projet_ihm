import java.awt.Graphics;
import java.io.*;
import java.util.*;
import java.awt.Color;

public class Dessin_Gomme extends Dessin_Figure
{
  public Dessin_Gomme(Gomme g)
  {
    super(g);
  }

  public void dessin(Graphics g,Figure fig)
  {
    g.setColor(fig.get_color());
    Iterator<Cercle> itg=fig.get_gommes().iterator();
    Cercle c;

    while(itg.hasNext())
    {
      c=itg.next();
      g.fillOval(c.get_x(),c.get_y(),c.get_rayon(),c.get_rayon());
    }
  }
}
