package simulator.model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhysicsSimulator {
	
	protected double timeReal;
	protected double timeActual;
	protected ForceLaws fl;
	protected List<Body> listBody;
	
	public PhysicsSimulator(Double time, ForceLaws fl) {
		
		try {
			this.timeActual = 0.00;
			
			if(time > 0 ){
				this.timeReal = time;
			}else{
				throw new IllegalArgumentException("Time error value");
			}
			
			if(fl != null){
				this.fl = fl;
			}else{
				throw new IllegalArgumentException("ForceLaws cant be null");
			}
		}catch(IllegalArgumentException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public double getTime() {
		return timeActual;
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
			o.move(this.timeReal);
		}
		timeActual =+ timeReal;
	}
	
	public void addBody(Body b) {
		if(this.listBody.contains(b)==false) {
			this.listBody.add(b);
		}else {
			throw new IllegalArgumentException("body cant no be added");
		}
	}
	
	public JSONObject getState() {
		
		JSONObject ps = new JSONObject();
		JSONArray bo = new JSONArray();
		
		for(Body e: listBody) {
			bo.put(e.getState());
		}
		
		ps.put("time", this.timeActual);
		ps.put("bodies", bo );
		return ps;
	}
	public String toString() {
		return getState().toString();
	}

}
