package computer;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Intel cpu = new Intel();
		
		Computer pc = new Computer(cpu);
		
		IRam ram = new Corsair("VERSION 1");
		pc.AddRam(ram);
		
		 Iterable<IRam> list  = pc.getRam();
		
		System.out.println(pc.toString());
		
	}

}
