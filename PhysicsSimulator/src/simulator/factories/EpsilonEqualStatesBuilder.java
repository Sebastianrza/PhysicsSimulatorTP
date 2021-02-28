package simulator.factories;

import org.json.JSONObject;

import simulator.control.EpsilonEqualStates;
import simulator.control.StateComparator;

public class EpsilonEqualStatesBuilder  extends Builder<StateComparator> {
	

	public EpsilonEqualStatesBuilder(String typetag) {
		super("epseq");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected StateComparator createTheInstance(JSONObject data) {
		// TODO Auto-generated method stub
		try {
		return new EpsilonEqualStates(0.0);
	
		}catch(Exception e){
			throw new IllegalArgumentException();
		}
	}
}
