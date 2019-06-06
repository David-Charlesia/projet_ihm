import java.awt.Graphics;

public class Dessin_Cercle extends Dessin_Figure
{
  public Dessin_Cercle(Cercle c)
  {
    super(c);
  }

  public void dessin(Graphics g,Figure fig)
  {
    int rayon=this.get_Figure().get_rayon();
    int x=fig.get_x();
    int y=fig.get_y();
    g.drawOval(fig.get_x(),fig.get_y(),fig.get_rayon(),fig.get_rayon());
  }

}
