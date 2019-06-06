import java.awt.Graphics;

public class Dessin_Triangle extends Dessin_Figure
{
  public Dessin_Triangle(Triangle t)
  {
    super(t);
  }

  public void dessin(Graphics g, Figure fig)
  {
    g.drawPolygon(fig.get_x_triangle(fig),fig.get_y_triangle(fig),3);
  }
}
