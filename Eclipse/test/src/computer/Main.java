package computer;

public class Main {

	public static void main(String[] args) {
		Intel cpu = new Intel();
		
		Computer pc = new Computer(cpu);
		
		System.out.println(pc.toString());
		
	}

}
