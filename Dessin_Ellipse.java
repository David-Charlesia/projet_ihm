import java.awt.Graphics;

public class Dessin_Ellipse extends Dessin_Figure
{
  public Dessin_Ellipse(Ellipse e)
  {
    super(e);
  }

  public void dessin(Graphics g,Figure fig)
  {
    g.drawOval(fig.get_x(),fig.get_y(),fig.get_rayon(),fig.get_rayon2());
  }

}
