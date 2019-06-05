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
  private int old_x;
  private int old_y;
  private Vue zone;
  private JPanel jp;
  private int height_frame;

  public Fenetre(Dessin dessin)
  {
    super("test");

    this.dessin=dessin;
    //this.getContentPane().add(new Vue (dessin));
    this.setSize(600, 400);
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

    JButton c=new JButton("Cercle");
    c.addActionListener(blis);
    jp.add(c);

    JButton r=new JButton("Rectangle");
    r.addActionListener(blis);
    jp.add(r);
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
