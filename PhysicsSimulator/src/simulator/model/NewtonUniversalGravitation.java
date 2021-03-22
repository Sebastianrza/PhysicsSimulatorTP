package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitation implements ForceLaws{
	
	protected double gc = 6.67E-11;
	protected double fij = 0.00;
	
	public  NewtonUniversalGravitation(double gc) {
		this.gc = gc;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void apply(List<Body> bs) {
		// TODO Auto-generated method stub
		
		for (Body b : bs) { 
			for(Body bo : bs){
				if(b.mass == 0.0) {
					b.acceleration = new Vector2D();
					b.velocity = new Vector2D();
				}else {
					if(!b.equals(bo)){

						b.addForce(force(b,bo));
						
					}
				}
			}
		}
	}
	
	private Vector2D force(Body a, Body b) {
		    Vector2D delta = b.getPosition().minus(a.getPosition());
		    double dist = delta.magnitude();
		    double magnitude = dist>0 ? (gc * a.getMass() * b.getMass()) / (dist * dist) : 0.0;
		    return delta.direction().scale(magnitude);
		   }
	public String toString() {
		return "Newton's Universal Gravitation";
	}

}




