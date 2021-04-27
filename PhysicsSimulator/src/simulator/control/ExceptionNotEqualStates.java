package simulator.control;

import org.json.JSONObject;

public class ExceptionNotEqualStates extends Exception{

	private static final long serialVersionUID = 1L;
	private static final String msg = "The states not equal in ";
	
	public ExceptionNotEqualStates(JSONObject js1, JSONObject js2, int i) {
		// TODO Auto-generated constructor stub
		
		super(msg + "States where they are different: \n" + js1 + "\n"+ js2 + "\n in the execution step: "+i);
	}
	

}
