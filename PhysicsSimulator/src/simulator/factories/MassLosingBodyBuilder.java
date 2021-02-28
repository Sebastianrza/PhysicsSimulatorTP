package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class MassLosingBodyBuilder extends Builder<Body>{

	

	public MassLosingBodyBuilder(String typetag) {
		super("mlb");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Body createTheInstance(JSONObject data) {
		
		if(!data.isEmpty()) {
		
		String id = data.getString("id");
		Vector2D position = (Vector2D) data.get("p");
		Vector2D velocity = (Vector2D) data.get("v");
		double lossFactor = data.getDouble("factor");
		double lossFrequency = data.getDouble("freq");
		double mass = data.getDouble("m");
		
		
		return new MassLossingBody(id, position, velocity, mass, lossFactor, lossFrequency);
		
		}else {
			throw new IllegalArgumentException();
		}

	}
}
