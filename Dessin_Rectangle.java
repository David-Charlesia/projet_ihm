import java.awt.Graphics;

public class Dessin_Rectangle extends Dessin_Figure
{
  public Dessin_Rectangle(Rectangle_mine r)
  {
    super(r);
  }

  public void dessin(Graphics g,Figure fig)
  {
    int x=fig.get_x();
    int y=fig.get_y();
    int width=fig.get_p().get_x()-x;
    int height=fig.get_p().get_y()-y;

    if(width<0)
    {
      int temp_x=x;
      x=Math.abs(width);
      width=temp_x;
    }
    if(height<0)
    {
      int temp_y=y;
      y=Math.abs(height);
      height=temp_y;
    }
    //System.out.pfintln("x="+x+" y="+y+" width="+width+" height="+height);
    g.drawRect(x,y,width,height);
  }
}
