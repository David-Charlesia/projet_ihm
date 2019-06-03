import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Fenetre extends JFrame
{
  private Dessin dessin;

  public Fenetre()
  {
    setVisible(true);
    setSize(600,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    validate();
  }

  public void getRectangle(Graphics g,int x, int y,Point p1,Point p2)
  {
    int widht=Math.abs(p1.get_x()-p2.get_x());
    int height=Math.abs(p1.get_y()-p2.get_y());

    //Rectangle rectangle=new Rectangle(x,y,widht,height);
    g.fillRect(x,y,widht+20,height+20);
    g.drawRect(x,y,widht,height);
    //return rectangle;
  }

  /*public Circle getCercle(int pos_x,int pos_y,int i_rayon)
  {
    double x=pos_x;
    double y=pos_y;
    double rayon=i_rayon;

    Circle cercle=new Circle(x,y,rayon);

    return cercle;
  }*/

  //public Ellipse getEllipse(int x,int y)

  public void PannelCentre(Graphics g)
  {
    JPanel jp=new JPanel();

    Iterator<Figure> ite=dessin.iterator();
    String type;
    int x;
    int y;
    Figure fig;
    Rectangle rectangle;
    while(ite.hasNext())
    {
      fig=ite.next();
      type=fig.type();

      switch(type)
      {
        case "Rectangle":
          Rectangle_mine rec=(Rectangle_mine)fig;
          Point p1=rec.get_p1();
          Point p2=rec.get_p2();
          x=rec.get_x();
          y=rec.get_y();
          //rectangle=getRectangle(g,x,y,p1,p2);
          //jp.add(g);
      }
    }
  }
/*
  public static void main(String[] args)
  {
    dessin=new Dessin(Yeah);
    dessin.add(new Rectangle_mine(5,5,0,5,5,40,45,false));
    new Fenetre();
  }*/
}
