public class TestSimulation{

  public static void main(String[] args){
    Simulation s1 = new Simulation(34,16);

    for(int i=0; i<5; i++){
      for(int j=0; j<5; j++){
        s1.realiseRecolte();
        s1.realiseProduction();
      }
      s1.afficheStatistiques();
    }
  }
}
