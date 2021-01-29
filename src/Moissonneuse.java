public class Moissonneuse extends Agent{
  //Station-essence
  private static StationEssence station;

  //Le reservoir de la Moissonneuse en litres
  public static final int RESERVOIRMAX = 3;
  //L'essence en Litres de la Moissonneuse en litres
  protected static double essence=1.5;

  public Moissonneuse(int ligne, int colonne){
    super(ligne, colonne);
    //Creation de la Station-Essence
    station = new StationEssence();
  }

  public void seDeplacer(int xnew, int ynew){
    //On choisit que la Moissonneuse consomme 1 cl d'essence par 10 m
    if(essence-super.distance(xnew, ynew)/10<0){
      System.out.println("Il suffit pas d'essence pour deplacer la Moissonneuse");

      System.out.println("La Moissonneuse " +this+ " a ete deplacee dans la Station-Essence pour remplir le Reservoir");
      //Deplacement de Moissonneuse dans la Station-Essence
      super.seDeplacer(station.getX(), station.getY());

      //La Moissonneuse remplit son reservoir
      essence=RESERVOIRMAX;
    }
    else{
      //change la position de l'objet en (xnew, ynew)
      super.x=xnew;
      super.y=ynew;
      essence-=super.distance(xnew, ynew);

    }

  }
  public String toString(){
    return "["+super.x+" "+super.y+"] de l'essence "+this.essence+ " litres";
  }

}
