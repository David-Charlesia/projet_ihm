import java.io.*;
import java.util.*;

public class Dessein extends java.util.ArrayList<Figure>
{
  private String nom;

  public Dessein(String nom)
  {
    this.nom=nom;
  }

  public String get_nom()
  {
    return this.nom;
  }

  public void set_nom(String nom)
  {
    this.nom=nom;
  }
}
