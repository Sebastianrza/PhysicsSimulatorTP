package simulator.factories;

import org.json.JSONObject;

import simulator.control.MassEqualStates;
import simulator.control.StateComparator;

public class MassEqualStatesBuilder extends Builder<StateComparator>{

	public MassEqualStatesBuilder() {
		//super(typetag);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected StateComparator createTheInstance(JSONObject data) {
		
		MassEqualStates mes;
		mes = new MassEqualStates();
		return mes;
	}

}
