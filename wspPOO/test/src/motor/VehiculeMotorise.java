package motor;

public class VehiculeMotorise extends Vehicule {

  private Moteur moteur;

  public VehiculeMotorise(String marque) {
    super(marque);
    this.moteur = new Moteur();
  }

  @Override
  public void accelerer(float deltaVitesse) {
	  System.out.println("enfant");

    moteur.consommer(deltaVitesse);
  }

  // ...

}