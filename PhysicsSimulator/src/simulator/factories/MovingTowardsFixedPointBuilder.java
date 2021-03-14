package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws>{


	public MovingTowardsFixedPointBuilder() {
		super("mtfp", "law of gravity moving towards a fixed point");
		// TODO Auto-generated constructor stub
	}
	protected JSONObject createData() {
		
		JSONObject bo = new JSONObject();
		
		bo.put("c", "point of origin");
		bo.put("g", "Gravitation");
		return bo;
		
	}
	@Override
	protected ForceLaws createTheInstance(JSONObject data) {
		// TODO Auto-generated method stub
		try {
		Vector2D mtfp = new Vector2D();
		double g = data.has("g") ? data.getDouble("g") : 9.81;
		return new MovingTowardsFixedPoint(mtfp, g);
		}catch(Exception e){
			throw new IllegalArgumentException();
		}
	}
	
	

}
