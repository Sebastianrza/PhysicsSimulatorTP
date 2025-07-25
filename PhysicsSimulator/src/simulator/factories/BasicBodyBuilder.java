package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body> {

	public BasicBodyBuilder() {
		super("basic", "basic physical body");
		// TODO Auto-generated constructor stub
	}
	protected JSONObject createData() {
		JSONObject ob = new JSONObject();
		ob.put("id", "Identifier of body");
		ob.put("pos", "Position in the sim");
		ob.put("vel", "Instant speed");
		ob.put("mass", "Mass of body");
		return ob;
		
	}
	@Override
	protected Body createTheInstance(JSONObject data) {
		 
		try {
		 
		 String id = data.getString("id");
		 
		 Vector2D position = new Vector2D (data.getJSONArray("p").getDouble(0), data.getJSONArray("p").getDouble(1));
		 Vector2D velocity = new Vector2D (data.getJSONArray("v").getDouble(0), data.getJSONArray("v").getDouble(1));
		 Double mass = data.getDouble("m");

		 return new Body(id, position, velocity, mass);
		 
		}catch(Exception eo) {
			throw new IllegalArgumentException();
		}
	
	}
	
	

}