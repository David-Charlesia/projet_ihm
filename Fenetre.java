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

  public Fenetre(Dessin dessin)
  {
    super("test");

    this.dessin=dessin;
    //this.getContentPane().add(new Vue (dessin));
    this.initialise();
    this.setSize(600, 400);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(true);
  }

  public void initialise()
  {
    this.setLayout(new BorderLayout());
    this.add(this.getPanelSud(),BorderLayout.SOUTH);
    this.add(new Vue (dessin),BorderLayout.CENTER);
    CurseurListener mlis=new CurseurListener();
    this.addMouseListener(mlis);
  }

  public JPanel getPanelSud()
  {
    JPanel jp=new JPanel();
    //addMouseListener(new MouseAdapter());
    BoutonListener blis=new BoutonListener();

    JButton c=new JButton("Cercle");
    c.addActionListener(blis);
    jp.add(c);
    return jp;
  }

  class CurseurListener extends MouseAdapter
  {
    public void mouseClicked(MouseEvent e)
    {
      x=e.getX();
      y=e.getY();
      if(forme!=null)
      {
        switch(forme)
        {
          case "Cercle":
          //get info rayon popup
            dessin.add(new Cercle(x,y,0,30,false));
            forme=null;
            initialise();
            repaint();
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
