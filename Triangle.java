public class Triangle extends Figure
{
  private Point p1;
  private Point p2;

  public Triangle(int x,int y,int rotation,int p1_x,int p1_y,int p2_x,int p2_y,boolean plein)
  {
    super(x,y,rotation,plein);
    this.p1=new Point(p1_x,p1_y);
    this.p2=new Point(p2_x,p2_y);
  }

  public Point get_p1()
  {
    return this.p1;
  }

  public void set_p1(int x, int y)
  {
    this.p1.set_x(x);
    this.p1.set_y(y);
  }

  public Point get_p2()
  {
    return this.p2;
  }

  public void set_p2(int x, int y)
  {
    this.p2.set_x(x);
    this.p2.set_y(y);
  }

  public String type()
  {
    return "Triangle";
  }
}
