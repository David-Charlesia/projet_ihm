import java.awt.Color;
import java.io.*;
import java.util.*;

public class Crayon extends Figure
{
  ArrayList<Point> points;
  public Crayon(int x,int y,double rotation,Color color)
  {
    super(x,y,rotation,false,color);
    this.points=new ArrayList<Point>();
    this.vue=new Dessin_Crayon(this);
  }

  public String type()
  {
    return "Crayon";
  }

  public void Crayon_add(Point p)
  {
    this.points.add(p);
  }

  public ArrayList<Point> get_trace()
  {
    return this.points;
  }
}
