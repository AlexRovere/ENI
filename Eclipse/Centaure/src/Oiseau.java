
public class Oiseau implements Siffleur,Animal {

	public void siffler () {
		System.out.println("l'oiseau siffle");
	}

	public void dormir() {
		System.out.println("l'oiseau dort");
	}
	
	public void communiquer() {
		this.siffler();
	}
}
