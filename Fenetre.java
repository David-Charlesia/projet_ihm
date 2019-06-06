import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Fenetre extends JFrame
{
  private Dessin dessin;
  private String forme;
  private int x;
  private int y;
  private boolean first_clic=false;
  private boolean second_clic=false;
  private int old_x;
  private int old_y;
  private int old_x_2;
  private int old_y_2;
  private int rayon;
  private int rayon2;
  private Vue zone;
  private JPanel jp;
  private int height_frame;

  public Fenetre(Dessin dessin)
  {
    super("test");

    this.dessin=dessin;
    //this.getContentPane().add(new Vue (dessin));
    //this.getContentPane().setPreferredSize(600,400);
    int f_width=600;
    int f_height=400;

    this.setSize(f_width,f_height);
    /*
    Dimension actualSize = this.getContentPane().getSize();

    int extraW = f_width - actualSize.width;
    int extraH = f_height - actualSize.height;

    // Now set the size.
    this.setSize(f_width + extraW, f_height + extraH);

    System.out.println(f_width+" "+f_height);
    System.out.println(extraW+" "+extraH);
    System.out.println(f_width + extraW+" "+f_height + extraH);
    */

    //this.pack();
    this.initialise();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(true);
  }

  public void initialise()
  {
    this.setLayout(new BorderLayout());
    initPanelSud();
    this.add(jp,BorderLayout.SOUTH);
    zone=new Vue(dessin);
    this.add(zone,BorderLayout.CENTER);
    height_frame=(int)this.getSize().getHeight();
    CurseurListener mlis=new CurseurListener();
    this.addMouseListener(mlis);
  }

  public void actualiser()
  {
    zone=new Vue(dessin);
    //add(zone,BorderLayout.CENTER);
    repaint();
  }

  public void initPanelSud()
  {
    jp=new JPanel();
    //addMouseListener(new MouseAdapter());
    BoutonListener blis=new BoutonListener();

    JButton s=new JButton("Segment");
    s.addActionListener(blis);
    jp.add(s);

    JButton r=new JButton("Rectangle");
    r.addActionListener(blis);
    jp.add(r);

    JButton t=new JButton("Triangle");
    t.addActionListener(blis);
    jp.add(t);

    JButton c=new JButton("Cercle");
    c.addActionListener(blis);
    jp.add(c);

    JButton e=new JButton("Ellipse");
    e.addActionListener(blis);
    jp.add(e);
  }

  class CurseurListener extends MouseAdapter
  {
    public void mouseClicked(MouseEvent e)
    {
      if(forme!=null)
      {
        x=e.getX();
        y=e.getY();
        //System.out.println(x+","+y);
        switch(forme)
        {
          case "Cercle":
          //get info rayon popup
            if(!first_clic)
            {
              old_x=x;
              old_y=y;
              first_clic=true;
            }else
            {
              dessin.add(new Cercle(old_x,old_y,0,x-old_x,false));
              forme=null;
              first_clic=false;
              actualiser();
            }
            break;

          case "Rectangle":
            if(!first_clic)
            {
              old_x=x;
              old_y=y;
              //old_y=height_frame-y;
              first_clic=true;
            }else
            {
              //y=height_frame-y;
              System.out.println("1) x="+old_x+" y="+old_y);
              System.out.println("2) x="+x+" y="+y);
              dessin.add(new Rectangle_mine(old_x,old_y,0,x,y,false));
              first_clic=false;
              forme=null;
              actualiser();
            }
            break;

          case "Triangle":
            if(!first_clic)
            {
              old_x=x;
              old_y=y;
              first_clic=true;
            }else if(!second_clic)
            {
              old_x_2=x;
              old_y_2=y;
              second_clic=true;
            }else
            {
              dessin.add(new Triangle(old_x,old_y,0,old_x_2,old_y_2,x,y,false));
              first_clic=false;
              second_clic=false;
              forme=null;
              actualiser();
            }
            break;

          case "Ellipse":
            if(!first_clic)
            {
              old_x=x;
              old_y=y;
              first_clic=true;
            }else
            {
              rayon=x-old_x;
              rayon2=y-old_y;

              dessin.add(new Ellipse(old_x,old_y,0,rayon,rayon2,false));
              first_clic=false;
              forme=null;
              actualiser();
            }
            break;

          case "Segment":
            if(!first_clic)
            {
              old_x=x;
              old_y=y;
              first_clic=true;
            }else
            {
              dessin.add(new Segment(old_x,old_y,0,x,y));
              first_clic=false;
              forme=null;
              actualiser();
            }
            break;
        }
      }

    }
  }

  class BoutonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String commande=e.getActionCommand();
      forme=commande;
    }
  }

}
