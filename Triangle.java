public class Triangle extends Figure
{
  private Point p1;
  private Point p2;
  private Point p3;

  public Triangle(int x,int y,int rotation,int p1_x,int p1_y,int p2_x,int p2_y,int p3_x,int p3_y,boolean plein)
  {
    super(x,y,rotation,plein);
    this.p1=new Point(p1_x,p1_y);
    this.p2=new Point(p2_x,p2_y);
    this.p3=new Point(p3_x,p3_y);
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

  public Point get_p3()
  {
    return this.p3;
  }

  public void set_p3(int x, int y)
  {
    this.p3.set_x(x);
    this.p3.set_y(y);
  }
}
