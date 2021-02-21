package simulator.model;

import java.util.List;

public class MovingTowardsFixedPoint implements ForceLaws {

	protected double gc = 9.81;
	@Override
	public void apply(List<Body> bs) {
		// TODO Auto-generated method stub
		for(int i = 0; i < bs.size(); i++) {
			Body bo = bs.get(i);
			bo.setAcceleration(bo.getPosition().direction().scale(-gc));
		}
	}

}
