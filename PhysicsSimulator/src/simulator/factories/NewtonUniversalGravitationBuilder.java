package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws>{
	
	public NewtonUniversalGravitationBuilder() {
		super("nlug");
		// TODO Auto-generated constructor stub
	}


	double cons = 6.67E-11;
	

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
