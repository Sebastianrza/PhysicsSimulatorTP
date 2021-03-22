package simulator.model;

import java.util.List;


import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws {

	protected double gc = 9.81;
	protected Vector2D _c;
	
	public MovingTowardsFixedPoint(Vector2D vmtfp, double gc) {
		this.gc = gc;
		this._c = new Vector2D();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void apply(List<Body> bs) {
		// TODO Auto-generated method stub
		for(Body b :bs) {
			b.addForce(_c.minus(b.getPosition().direction().scale(gc*b.getMass())));
		}
	}
	public String toString() {
		return "Moving Towards Fixed Point";
	}
	

}
