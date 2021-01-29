import java.util.Random;
public class Simulation{
  private static Terrain t = new Terrain(20,20);
  private Agent[] tabAgents;
  private Ressource[] tabRessources;

  protected static int nbRecoltes=0;
  private static int nbProduction=0;


  public Simulation(int m, int n){
    //Creation de m cases pour le tableau de ressources
    tabRessources = new Cereale[m];
    //Creation de n cases pour le tableau d'agents
    tabAgents = new Moissonneuse[n];
    //Place aleatoirement m ressources sur le terrain
    for(int i=0; i<m; i++){
      //Creation de nom aleatoire pour une cereale
      String nom="";
      //Creation de la quantite aleatoire entre 1 et 8 pour une cereale
      int quantite = (int)(Math.random()*8+1);
      //numero aleatoire entre 1 et 6
      int num = (int)(Math.random()*6+1);
      //Attribution aleatoire pour le nom de Cereale
      switch (num){
        case 1 : nom="Avoine";
                  break;
        case 2 : nom="Riz";
                  break;
        case 3 : nom="Ble";
                  break;
        case 4 : nom="Mais";
                  break;
        case 5 : nom="Orge";
                  break;
        case 6 : nom="Sorgo";
                  break;
      }
      Ressource cereale = new Cereale(nom, quantite);
      tabRessources[i] = cereale;
      //Placement aleatoire d'une cereale dans la case
      int x=(int)(Math.random()*t.NBLIGNESMAX);
      int y=(int)(Math.random()*t.NBCOLONNESMAX);
      t.setCase(x,y,cereale);
    }
    //Genere n agents et les place dans le tableau d'Agents
    for(int i=0; i<n; i++){
        Agent moissonneuse = new Moissonneuse((int)(Math.random()*t.NBLIGNESMAX),(int)(Math.random()*t.NBCOLONNESMAX));
        tabAgents[i] = moissonneuse;
    }
  }
  //Realisation de plusieures recoltes
  public void realiseRecolte(){
      for(int i=0; i<tabAgents.length; i++){
        //Verifie si la Moissonneuse est dans la meme case que la Cereale
        if(!t.caseEstVide(tabAgents[i].getX(),tabAgents[i].getY())){
          //On met la quantite de cereales dans l'entrepot
          Ressource r = t.getCase(tabAgents[i].getX(),tabAgents[i].getY());
          nbRecoltes+=r.getQuantite();

          System.out.println("Les cereales de la case ("+tabAgents[i].getX()+", "+tabAgents[i].getY()+") ont ete recoltee par la Moissonneuse");
          t.videCase(tabAgents[i].getX(),tabAgents[i].getY());


        }
      int xnew = (int)(Math.random()*t.NBLIGNESMAX);
      int ynew = (int)(Math.random()*t.NBCOLONNESMAX);
      //Deplacement de la Moissonneuse dans la nouvelle case
      tabAgents[i].seDeplacer(xnew, ynew);
      //System.out.println("La Moissonneuse " +tabAgents[i]+ " s'est deplacee au point ("+xnew+" "+ynew+")");
      }
    }
  protected final double probaRepousse=1.0;
  //Methode pour faire pousser les cereales
  public void realiseProduction(){
    int x=(int)(Math.random()*t.NBLIGNESMAX);
    int y=(int)(Math.random()*t.NBCOLONNESMAX);
    //Verification de probabilite obtenue (> probaRepousse) et de bon type de la case
    if( (Math.random()*2 <= probaRepousse) && t.caseEstVide(x,y) ){
      int i=(int)(Math.random()*tabRessources.length);
      t.setCase(x,y,tabRessources[i]);
      System.out.println("Les cereales "+tabRessources[i]+" se sont repoussees");
      nbProduction += tabRessources[i].getQuantite();
    }

  }
  public void afficheStatistiques(){
    System.out.println("Le nombre de recoltes effectuees : "+nbRecoltes);
    System.out.println("Le nombre de cereales produites : "+nbProduction);
    t.affiche();
  }

}
