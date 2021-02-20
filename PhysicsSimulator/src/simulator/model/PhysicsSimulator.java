package simulator.model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhysicsSimulator {
	
	protected double time;
	protected ForceLaws fl;
	protected List<Body> listBody;
	
	public PhysicsSimulator(Double time, ForceLaws fl) {
		
		try {
			this.time = 0.0;
			this.fl = fl;
		}catch(IllegalArgumentException e) {
			System.out.println("Error: "+e.getMessage());
		}
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
		}
		this.fl.apply(listBody);
		for(Body o: listBody) {
			o.move(this.time);
		}
		this.setTime(time+this.getTime());
	}
	
	public void addBody(Body b) {
		this.listBody.add(b);
	}
	
	public JSONObject getState() {
		
		JSONObject ps = new JSONObject();
		JSONArray bo = new JSONArray();
		
		for(Body e: listBody) {
			bo.put(e.getState());
		}
		
		ps.put("time", this.getTime());
		ps.put("bodies", bo );
		return ps;
	}
	public String toString() {
		return getState().toString();
	}

}
