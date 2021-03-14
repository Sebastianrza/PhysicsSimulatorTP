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
		
		for (int i = 0; i < bs.size(); i++) { 
			Body boi = bs.get(i);
			
			if(boi.getMass() == 0.0) {
				boi.acceleration = new Vector2D();
				boi.velocity = new Vector2D();
				
			}else {
				for (int j = 0; j < bs.size(); j++) {
					Body boj = bs.get(j);
					if(i!=j){
						double fij = 0.00;
						fij = gc * ( ( boi.getMass() * boj.getMass() ) / ( Math.pow(boj.getPosition().distanceTo(boi.getPosition()), 2) ) );
						
						Vector2D ijDirection = boj.getPosition().minus(boi.getPosition()); // no estoy muy claro que esto sea asi 
						ijDirection.scale(fij);
						
						boi.setForce(ijDirection);
					}
				}
			}
		}
	}

}
