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
    int x;
    int y;
    int width;
    int height;
    int temp_x;
    int temp_y;

    while(ite.hasNext())
    {
      fig=ite.next();
      type=fig.type();
      x=fig.get_x();
      y=fig.get_y();

      switch(type)
      {
        case "Cercle":
          Cercle c=(Cercle)fig;
          int rayon=c.get_rayon();

          g.drawOval(x-rayon,y-rayon*2,rayon*2,rayon*2);
          break;

        case "Rectangle":
          Rectangle_mine r=(Rectangle_mine)fig;
          width=r.get_p().get_x()-x;
          height=r.get_p().get_y()-y;
          if(width<0)
          {
            temp_x=x;
            x=Math.abs(width);
            width=temp_x;
          }
          if(height<0)
          {
            temp_y=y;
            y=Math.abs(height);
            height=temp_y;
          }


          System.out.println("x="+x+" y="+y+" width="+width+" height="+height);
          g.drawRect(x,y,width,height);
          break;
      }
    }
  }
}
