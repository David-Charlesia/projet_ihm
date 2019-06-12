import java.awt.Color;

public class Texte extends Figure
{
  private String text;
  public Texte(int x,int y,Color color,String text)
  {
    super(x,y,0,false,color);
    this.text=text;
    this.vue=new Dessin_Text(this);
  }

  public String get_text()
  {
    return this.text;
  }
}
