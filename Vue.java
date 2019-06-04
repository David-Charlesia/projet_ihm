import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.io.*;

public class Vue extends JPanel
{
  private Dessin dessin;

  public Vue(Dessin dessin)
  {
    super();
    this.dessin=dessin;
  }
  public void paint(Graphics g)
  {
    aff(g);
    //g.drawOval(5,5,60,60);
  }


  public void aff(Graphics g)
  {
    Iterator<Figure> ite=dessin.iterator();
    Figure fig;
    String type;

    while(ite.hasNext())
    {
      fig=ite.next();
      type=fig.type();

      switch(type)
      {
        case "Cercle":
          Cercle c=(Cercle)fig;
          int x=c.get_x();
          int y=c.get_y();
          int rayon=c.get_rayon();

          g.drawOval(x-rayon,y-rayon*2,rayon*2,rayon*2);
          break;
      }
    }
  }
}
