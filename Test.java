import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.io.*;

public class Test
{
  public static void main(String[] args)
  {
    Dessin dessin=new Dessin("Yeah");
    //dessin.add(new Rectangle_mine(5,5,0,5,5,100,105,false));
    dessin.add(new Cercle(5,5,0,50,false));

    dessin.add(new Cercle(60,65,0,30,false));

    /*
    JFrame frame= new JFrame("Test");
    frame.getContentPane().add(new Vue(dessin));
    frame.setSize(600, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(true);*/

    Fenetre f=new Fenetre(dessin);

  }
}
