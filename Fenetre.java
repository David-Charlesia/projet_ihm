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
import java.awt.event.MouseMotionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTabbedPane;

public class Fenetre extends JFrame
{
  private JPanel general;
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
  private JButton b_select;
  BoutonListener blis=new BoutonListener();
  private JTabbedPane onglets;
  private JButton remplis;
  private boolean remplissage=false;
  private Color couleur;
  private JColorChooser tcc;
  private Crayon cray=new Crayon(0,0,0,couleur);


  public Fenetre(Dessin dessin)
  {
    super("test");

    this.dessin=dessin;
    //this.getContentPane().add(new Vue (dessin));
    //this.getContentPane().setPreferredSize(600,400);
    int f_width=800;
    int f_height=600;

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
    onglets=new JTabbedPane();

    general=new JPanel();
    general.setLayout(new BorderLayout());
    initPanelNord();
    general.add(jp,BorderLayout.NORTH);

    zone=new Vue(dessin);
    CurseurListener mlis=new CurseurListener();
    zone.addMouseListener(mlis);
    MouveMouseListener mml=new MouveMouseListener();
    zone.addMouseMotionListener(mml);

    general.add(zone,BorderLayout.CENTER);

    onglets.add("General",general);
    onglets.add("Couleurs",initPanelDroite());

    this.add(onglets);
  }

  public void actualiser()
  {
    zone=new Vue(dessin);
    b_select.setBackground(null);
    //add(zone,BorderLayout.CENTER);
    repaint();
  }

  public JPanel initPanelDroite()
  {
    JPanel couleurs=new JPanel();

    tcc= new JColorChooser();
    CouleurListener cl=new CouleurListener();
    tcc.getSelectionModel().addChangeListener(cl);
    tcc.setBorder(BorderFactory.createTitledBorder("Choisissez votre couleur"));
    couleurs.add(tcc);
    return couleurs;
  }

  public void initPanelNord()
  {
    jp=new JPanel();
    //addMouseListener(new MouseAdapter());

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

    JButton crayon=new JButton("Crayon");
    crayon.addActionListener(blis);
    jp.add(crayon);

    remplis=new JButton("Remplissage");
    remplis.addActionListener(blis);
    jp.add(remplis);

    JButton del=new JButton("Supprimer");
    del.addActionListener(blis);
    jp.add(del);
  }

  class CurseurListener extends MouseAdapter
  {
    int pos_x;
    int pos_y;
    int rayon;
    public void mouseClicked(MouseEvent e)
    {
      System.out.println("Souris click !");
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
              pos_x=old_x;
              pos_y=old_y;
              rayon=Math.abs(x-old_x);
              if(old_x>x)
              {
                pos_x=x;
              }
              if(old_y>y)
              {
                pos_y=y;
              }
              dessin.add(new Cercle(pos_x,pos_y,0,rayon,remplissage,couleur));
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
              //System.out.println("1) x="+old_x+" y="+old_y);
              //System.out.println("2) x="+x+" y="+y);
              dessin.add(new Rectangle_mine(old_x,old_y,0,x,y,remplissage,couleur));
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
              //System.out.println(x+" "+y);
              dessin.add(new Triangle(old_x,old_y,0,old_x_2,old_y_2,x,y,remplissage,couleur));
              //System.out.println("Yeah");
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
              rayon=Math.abs(x-old_x);
              rayon2=Math.abs(y-old_y);
              if(old_x>x)
              {
                old_x=x;
              }
              if(old_y>y)
              {
                old_y=y;
              }

              dessin.add(new Ellipse(old_x,old_y,0,rayon,rayon2,remplissage,couleur));
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
              dessin.add(new Segment(old_x,old_y,0,x,y,couleur));
              first_clic=false;
              forme=null;
              actualiser();
            }
            break;
          case "Crayon":
            forme=null;
            //cray.Crayon_add(null);
            break;
        }
      }

    }
  }

  class MouveMouseListener implements MouseMotionListener
  {
    //Point pi;
    java.awt.Point mp;
    boolean ajouter=false;

    public void mouseDragged(MouseEvent med)
    {
      if(forme=="Crayon")
      {
        if(!ajouter)
        {
          cray.set_color(couleur);
          dessin.add(cray);
          ajouter=true;
        }
        mp=med.getPoint();
        //mp=pi.getLocation();
        cray.Crayon_add(new Point((int)mp.getX(),(int)mp.getY()));
        //cray.vue.dessin(g);
        actualiser();
      }
    }
    public void mouseMoved(MouseEvent med2){}

    public void mouseExited(MouseEvent e){}
  }

  class BoutonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String commande=e.getActionCommand();
      if(commande=="Remplissage")
      {
        if(remplissage)
        {
          remplissage=false;
          remplis.setBackground(null);
        }else
        {
          remplissage=true;
          remplis.setBackground(couleur);
        }
      }else
      {
        if(b_select!=null)
        {
          b_select.setBackground(null);
        }
        b_select=(JButton)e.getSource();
        b_select.setBackground(Color.RED);
        System.out.println(commande);
        forme=commande;
      }

      if(commande=="Supprimer")
      {
        while (!dessin.isEmpty())
        {
          dessin.remove(dessin.size()-1);
        }
        actualiser();
      }
    }
  }

  class CouleurListener implements ChangeListener
  {
    public void stateChanged(ChangeEvent cou)
    {
      couleur=tcc.getColor();
      if(remplissage==true)
      {
        remplis.setBackground(couleur);
      }
    }
  }

}
