package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws>{
	
	double cons = 6.67E-11;
	public NewtonUniversalGravitationBuilder() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ForceLaws createTheInstance(JSONObject data) {
		// TODO Auto-generated method stub
		try {
		return new NewtonUniversalGravitation(cons);
		}catch(Exception e){
			throw new IllegalArgumentException();
		}
	}

}
