package animal;

class Chien extends Animal implements IManger {

	@Override
	public void manger() {
    	System.out.println("le chien mange");
    }
	
	public void sauter() {
    	System.out.println("le chien saute");

	}
   
}