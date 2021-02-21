package simulator.control;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.PhysicsSimulator;

public class MassEqualStates implements StateComparator {
	
	protected double time;
	protected ForceLaws fl;
	protected PhysicsSimulator ps = new PhysicsSimulator(null, null);

	@Override
	public boolean equal(JSONObject s1, JSONObject s2) {
		
		return false;
	}

}
