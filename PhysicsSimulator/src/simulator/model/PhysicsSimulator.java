package simulator.model;

import java.util.List;

import org.json.JSONObject;

public class PhysicsSimulator {
	
	protected double time;
	protected ForceLaws fl;
	protected List<Body> listBody;
	
	public PhysicsSimulator(Double time, ForceLaws fl) {
		
		this.time = time;
		this.fl = fl;
	}
	
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public ForceLaws getFl() {
		return fl;
	}

	public void setFl(ForceLaws fl) {
		this.fl = fl;
	}

	public List<Body> getListBody() {
		return listBody;
	}

	public void setListBody(List<Body> listBody) {
		this.listBody = listBody;
	}
	
	//metodos

	public void advance() {
		for(Body o: listBody) {
			o.resetForce();
			o.move(this.time);
		}
		this.fl.apply(listBody);
		this.setTime(this.getTime()+1);
	}
	
	public void addBody(Body b) {
		this.listBody.add(b);
	}
	
	public JSONObject getState() {
		
		
		
	}
	public String toString() {
		return getState().toString();
	}

}
