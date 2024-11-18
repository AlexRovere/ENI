package toolbox;

public class BasicToolbox extends Toolbox implements IScrewdriver {
	
	public BasicToolbox(String name) {
		super(name);
	}

	@Override
	public void screw() {
		System.out.println("basic tool screw");
	}

	@Override
	public void unscrew() {
		System.out.println("basic tool unscrew");
	}
	
}
