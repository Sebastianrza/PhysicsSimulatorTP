package simulator.factories;

import org.json.JSONObject;

import simulator.control.StateComparator;

public class EpsilonEqualStates implements StateComparator{

	
	protected double eps;
	public EpsilonEqualStates(Double eps){
		this.eps = eps;
	}
	
	@Override
	public boolean equal(JSONObject s1, JSONObject s2) {
		// TODO Auto-generated method stub
		return false;
	}
}
