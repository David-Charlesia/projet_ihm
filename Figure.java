public class Figure
{
  private double rotation;
  private boolean plein;
  private int x;
  private int y;
  public Dessin_Figure vue;

  public Figure(int x,int y,double rotation,boolean plein)
  {
    this.x=x;
    this.y=y;
    this.plein=plein;
    this.rotation=rotation;
    this.vue=new Dessin_Figure(this);
  }

  public int get_x()
  {
    return this.x;
  }

  public void set_x(int x)
  {
    this.x=x;
  }

  public int get_y()
  {
    return this.y;
  }

  public void set_y(int y)
  {
    this.y=y;
  }

  public double getRotation()
  {
    return this.rotation;
  }

  public void setRotation(int rotation)
  {
    this.rotation=rotation;
  }

  public boolean get_plein()
  {
    return this.plein;
  }

  public void set_plein(boolean plein)
  {
    this.plein=plein;
  }

  public String type()
  {
    return "Figure";
  }

  public int get_rayon()
  {
    return 0;
  }

  public int get_rayon2()
  {
    return 0;
  }
}
