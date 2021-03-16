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
						fij = 0.00;
						
						fij = gc * (b.mass * bo.mass);
						fij = fij / (Math.pow((bo.position.distanceTo(b.position)),2));
						
						Vector2D Dforce = bo.position.minus(b.position);
						b.addForce(Dforce.scale(fij));
						
					}
				}
			}
		}
	}

}










/*for (int j = 0; j < bs.size(); j++) {
	Body boj = bs.get(j);
	if(i!=j){
		double fij = 0.00;
		fij = gc * ( ( boi.getMass() * boj.getMass() ) / ( Math.pow(boj.getPosition().distanceTo(boi.getPosition()), 2) ) );
		
		Vector2D ijDirection = boj.getPosition().minus(boi.getPosition()); // no estoy muy claro que esto sea asi 
		ijDirection.scale(fij);
		
		boi.setForce(ijDirection);
	}
}*/
