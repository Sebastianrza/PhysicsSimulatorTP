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
		 
		 Vector2D position = new Vector2D (firstDouble(data.get("p").toString()), seconDouble(data.get("p").toString()));
		 Vector2D velocity = new Vector2D (firstDouble(data.get("v").toString()), seconDouble(data.get("v").toString()));
		 Double mass = data.getDouble("m");

		 return new Body(id, position, velocity, mass);
		 
		}catch(Exception eo) {
			throw new IllegalArgumentException();
		}
	
	}
	
	protected double firstDouble (String s){
		return Double.parseDouble(s.substring(1, (s.indexOf(','))));
	}
	protected double seconDouble (String s){
		return Double.parseDouble(s.substring((s.indexOf(','))+1, s.length() -1));

	}
	

}