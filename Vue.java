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

  public int[] get_x_triangle(Triangle t)
  {
    int[] tab=new int[3];
    tab[0]=t.get_x();
    tab[1]=t.get_p1().get_x();
    tab[2]=t.get_p2().get_x();

    return tab;
  }

  public int[] get_y_triangle(Triangle t)
  {
    int[] tab=new int[3];
    tab[0]=t.get_y();
    tab[1]=t.get_p1().get_y();
    tab[2]=t.get_p2().get_y();

    return tab;
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
      fig.vue.dessin(g,fig);
      /*type=fig.type();
      x=fig.get_x();
      y=fig.get_y();*/

      /*
      switch(type)
      {
        case "Cercle":
          Cercle c=(Cercle)fig;
          int rayon=c.get_rayon();
          g.drawOval(x-rayon,y-rayon*2,rayon*2,rayon*2);
          break;

        case "Rectangle":
          Rectangle_mine r=(Rectangle_mine)fig;
          System.out.println(x+" "+y);
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
          //System.out.println("x="+x+" y="+y+" width="+width+" height="+height);
          g.drawRect(x,y,width,height);
          break;

        case "Triangle":
          Triangle t=(Triangle)fig;
          g.drawPolygon(get_x_triangle(t),get_y_triangle(t),3);
          break;

        case "Ellipse":
          Ellipse e=(Ellipse)fig;
          g.drawOval(e.get_x(),e.get_y(),e.get_rayon(),e.get_rayon2());
          break;

        case "Segment":
          Segment s=(Segment)fig;
          g.drawLine(x,y,s.get_p().get_x(),s.get_p().get_y());
          break;
      }*/
    }
  }
}
