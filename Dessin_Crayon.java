import java.awt.Graphics;
import java.io.*;
import java.util.*;

public class Dessin_Crayon extends Dessin_Figure
{
  public Dessin_Crayon(Crayon c)
  {
    super(c);
  }
  public void dessin(Graphics g, Figure fig)
  {
    g.setColor(fig.get_color());
    Iterator<Point> itep=fig.get_trace().iterator();
    Point p1=itep.next();
    p1=itep.next();
    Point p2=itep.next();

    while(itep.hasNext())
    {
      if(p2==null)
      {
        p1=itep.next();
        p2=p1;
      }
      g.drawLine(p1.get_x(),p1.get_y(),p2.get_x(),p2.get_y());
      p1=p2;
      p2=itep.next();
    }
  }
}
