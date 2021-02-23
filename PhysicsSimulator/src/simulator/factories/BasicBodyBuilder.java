package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body> {

	public BasicBodyBuilder() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Body createTheInstance(JSONObject data) {
		 String id = data.getString("id");
		 Vector2D position = (Vector2D) data.get("p");
		 Vector2D velocity = (Vector2D) data.get("v");; 
		 Double mass = data.getDouble("mass");
		 
		 return new Body(id, position, velocity, mass);
	}

}
