package simulator.model;

import java.util.List;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws {

	protected double gc = 9.81;
	protected Vector2D vmtfp;
	
	public MovingTowardsFixedPoint(Vector2D vmtfp, double gc) {
		this.gc = gc;
		this.vmtfp = new Vector2D();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void apply(List<Body> bs) {
		// TODO Auto-generated method stub
		for(int i = 0; i < bs.size(); i++) {
			Body bo = bs.get(i);
			bo.setAcceleration(bo.getPosition().direction().scale(-gc));
		}
	}
	
	

}
