import java.awt.Graphics;

public class Dessin_Segment extends Dessin_Figure
{
  public Dessin_Segment(Segment s)
  {
    super(s);
  }

  public void dessin(Graphics g,Figure fig)
  {
    g.drawLine(fig.get_x(),fig.get_y(),fig.get_p().get_x(),fig.get_p().get_y());
  }
}
