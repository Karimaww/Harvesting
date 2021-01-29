import java.lang.Math;
public class Cereale extends Ressource{
  private String nom;
  private int quantite;

  public Cereale(String nom, int quantite){
    super(nom, quantite);
    this.nom=nom;
    this.quantite=quantite;
  }

  public Cereale clone(){
    return new Cereale(this.nom, this.quantite);
  }

}
