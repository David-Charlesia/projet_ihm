import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Fenetre extends JFrame
{
  private Dessin dessin;

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
  }

  public JPanel getPanelSud()
  {
    JPanel jp=new JPanel();
    BoutonListener blis=new BoutonListener();

    JButton c=new JButton("Cercle");
    c.addActionListener(blis);
    jp.add(c);
    return jp;
  }



  class BoutonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String commande=e.getActionCommand();

      switch(commande)
      {
        case "Cercle":
          
      }
    }
  }

}
