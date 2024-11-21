
public class Centaure implements Animal, Siffleur {

	@Override
	public void siffler() {	
		System.out.println("Le centaure siffle");
	}

	@Override
	public void dormir() {		
		System.out.println("Le centaure dort");
	}

	@Override
	public void communiquer() {		
		System.out.println("Le centaure parle");
	}

}
