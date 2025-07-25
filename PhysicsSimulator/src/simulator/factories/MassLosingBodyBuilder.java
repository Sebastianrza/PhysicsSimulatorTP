package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class MassLosingBodyBuilder extends Builder<Body>{


	public MassLosingBodyBuilder() {
		super("mlb","Mass losing body");
		// TODO Auto-generated constructor stub
	}
	
	protected JSONObject createData() {
		JSONObject bo = new JSONObject();
		bo.put("id", "Identifier of body");
		bo.put("pos", "Position in the sim");
		bo.put("vel", "Instant speed");
		bo.put("mass", "Mass of body");
		bo.put("freq", "Mass losing frecuency");
		bo.put("factor", "Mass losing factor");
		
		return bo;
	}
	@Override
	protected Body createTheInstance(JSONObject data) {
		
		if(!data.isEmpty()) {
		
		String id = data.getString("id");
		Vector2D position = new Vector2D (data.getJSONArray("p").getDouble(0), data.getJSONArray("p").getDouble(1)); 
		Vector2D velocity = new Vector2D (data.getJSONArray("v").getDouble(0), data.getJSONArray("v").getDouble(1)); 
		double lossFactor = data.getDouble("factor");
		double lossFrequency = data.getDouble("freq");
		double mass = data.getDouble("m");
		
		
		return new MassLossingBody(id, position, velocity, mass, lossFactor, lossFrequency);
		
		}else {
			throw new IllegalArgumentException();
		}

	}

}
