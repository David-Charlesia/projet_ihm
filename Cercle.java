public class Cercle extends Figure
{
  private int rayon;

  public Cercle(int x,int y,double rotation,int rayon,boolean plein)
  {
    super(x,y,rotation,plein);
    this.rayon=rayon;
  }

  public int get_rayon()
  {
    return this.rayon;
  }

  public void set_rayon(int rayon)
  {
    this.rayon=rayon;
  }

  public String type()
  {
    return "Cercle";
  }
}
