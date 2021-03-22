package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws>{
	
	public NewtonUniversalGravitationBuilder() {
		super("nlug", "Newton's law of universal gravitation");
		// TODO Auto-generated constructor stub
	}


	double cons = 6.67E-11;
	
	protected JSONObject createData() {
		
		JSONObject bo = new JSONObject();
		
		bo.put("G", "Gravitation");
		return bo;
		
	}
	@Override
	protected ForceLaws createTheInstance(JSONObject data) {
		// TODO Auto-generated method stub
		if(!data.has("G")) {
			data.put("G", cons);
		}
		return new NewtonUniversalGravitation(data.getDouble("G"));
	}
	
	

}
