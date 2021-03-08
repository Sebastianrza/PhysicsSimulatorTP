package simulator.factories;

import org.json.JSONObject;

import simulator.control.MassEqualStates;
import simulator.control.StateComparator;

public class MassEqualStatesBuilder extends Builder<StateComparator>{


	public MassEqualStatesBuilder() {
		super("masseq","Mass equal states");
		// TODO Auto-generated constructor stub
	}
	protected JSONObject createData() {
		return super.createData();
	}

	@Override
	protected StateComparator createTheInstance(JSONObject data) {
		try {
		MassEqualStates mes;
		mes = new MassEqualStates();
		return mes;
		}catch(Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
}
