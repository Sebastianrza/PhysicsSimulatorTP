package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;


public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws>{

	Vector2D mtfp = new Vector2D();
	public MovingTowardsFixedPointBuilder() {
		super("mtfp", "law of gravity moving towards a fixed point");
		// TODO Auto-generated constructor stub
	}
	protected JSONObject createData() {
		
		JSONObject bo = new JSONObject();
		
		bo.put("c", "the point towards which bodies move(a json list of 2 numbers, e.g., [100.0,50.0])");
		bo.put("g", "the length of the acceleration vector (a number)");
		return bo;
		
	}
	@Override
	protected ForceLaws createTheInstance(JSONObject data) {
		// TODO Auto-generated method stub
		
		if(!data.has("g")) {
			data.put("g", 9.81);
		}
		if(!data.has("c")) {
			data.put("c", mtfp.asJSONArray());
		}
		
		return new MovingTowardsFixedPoint(new Vector2D(data.getJSONArray("c").getDouble(0), data.getJSONArray("c").getDouble(1)),data.getDouble("g"));
		
	}
	

}
