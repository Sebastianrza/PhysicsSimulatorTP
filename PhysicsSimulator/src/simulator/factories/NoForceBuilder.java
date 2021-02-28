package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NoForce;

public class NoForceBuilder extends Builder<ForceLaws>{

	public NoForceBuilder() {
		super("nf");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ForceLaws createTheInstance(JSONObject data) {
		// TODO Auto-generated method stub
		try {
		return new NoForce();
		}catch(Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
}
