import java.lang.Math;
public class Agent{
  //Coordonnes de l'Agent
  protected int x, y;
  public Agent(int ligne, int colonne){
    //numero de ligne
    x=ligne;
    //numero de colonne
    y=colonne;
  }
  public int getX(){return x;}
  public int getY(){return y;}

  public double distance(int x, int y){
    //la distance euclidienne entre l'objet courant et l'objet de coordonnees (x,y)
    return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
  }

  public void seDeplacer(int xnew, int ynew){
    //change la position de l'objet en (xnew, ynew)
    this.x=xnew;
    this.y=ynew;
  }
}
