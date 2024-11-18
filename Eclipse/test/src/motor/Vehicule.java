package motor;

public class Vehicule {

  private final String marque;
  protected float vitesse;

  public Vehicule(String marque) {
    this.marque = marque;
  }

  protected void accelerer(float deltaVitesse) {
	  System.out.println("parent");
    this.vitesse += deltaVitesse;
  }
  
  public void test() {
	  System.out.println("salut");
  }

  // ...

}