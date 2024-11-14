package computer;

public class Computer {
	ICpu cpu;
	
	Computer(ICpu computer) {
		this.cpu = computer;
	}
	
	public String toString() {
		return cpu.toString();
	}

}
