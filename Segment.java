public class Segment extends Rectangle
{
  public Segment(int x,int y,int rotation,int p1_x,int p1_y,int p2_x,int p2_y)
  {
    super(x,y,rotation,p1_x,p1_y,p2_x,p2_y,false);
  }

  public String type()
  {
    return "Segment";
  }
}
