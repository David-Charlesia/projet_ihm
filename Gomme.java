import java.awt.Color;
import java.io.*;
import java.util.*;

public class Gomme extends Figure
{
  ArrayList<Cercle> gommes;
  public Gomme()
  {
    super(0,0,0,true,new Color(238,238,238));
    this.gommes=new ArrayList<Cercle>();
    this.vue=new Dessin_Gomme(this);
  }

  public Gomme(ArrayList<Cercle> gommes)
  {
    super(0,0,0,true,new Color(238,238,238));
    this.gommes=gommes;
    this.vue=new Dessin_Gomme(this);
  }

  public String type()
  {
    return "Gomme";
  }

  public void Gomme_add(int x,int y,int taille)
  {
    this.gommes.add(new Cercle(x,y,0,taille,true,null));
  }

  public ArrayList<Cercle> get_gommes()
  {
    return this.gommes;
  }
}
