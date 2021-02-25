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
		/*for (int i = 0; i < bs.size(); i++) { // se podria hacer mas corto usando un foreach 
			Body bo = bs.get(i);
			
			if(bo.getMass() == 0.0) {
				bo.acceleration = new Vector2D();
				bo.velocity = new Vector2D();
			}else {
				
			}
		}*/
		
		for(Body bo: bs){
			if(bo.getMass() == 0.00){
				bo.acceleration = new Vector2D();
				bo.velocity = new Vector2D();
			}else{
				
			}
		}
	}

}
