package toolbox;

public class Main {

	public static void main(String[] args) {
		BasicToolbox basicTool = new BasicToolbox("Basic toolbox");
		
		basicTool.screw();
		
		WoodWorkToolbox woodwork = new WoodWorkToolbox("WoodWork toolbox");
		woodwork.screw();
	}

}
