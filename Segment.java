public class Segment extends Rectangle_mine
{
  public Segment(int x,int y,int rotation,int p1_x,int p1_y)
  {
    super(x,y,rotation,p1_x,p1_y,false);
    this.vue=new Dessin_Segment(this);
  }

  public String type()
  {
    return "Segment";
  }
}
