package computer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Computer {
	ICpu cpu;
	List<IRam> ram = new ArrayList<IRam>();
	
	Computer(ICpu computer) {
		this.cpu = computer;
	}
	
	public String toString() {
		return cpu.toString();
	}
	
	public void AddRam (IRam ram) {
		this.ram.add(ram);
	}
	
	public Collection<IRam> getRam() {
		return this.ram;
	}
	
	

}
