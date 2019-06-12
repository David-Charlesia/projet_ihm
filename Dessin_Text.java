import java.awt.Graphics;

public class Dessin_Text extends Dessin_Figure
{
  public Dessin_Text(Texte t)
  {
    super(t);
  }
  public void dessin(Graphics g,Figure fig)
  {
    g.setColor(fig.get_color());

    g.drawString(fig.get_text(),fig.get_x(),fig.get_y());
  }
}
