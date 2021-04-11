package simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhysicsSimulator {
	
	protected double timeReal;
	protected double timeActual;
	protected ForceLaws fl;
	protected List<Body> listBody;
	protected List<SimulatorObserver> listObserver = new ArrayList<>();
	
	public PhysicsSimulator(Double time, ForceLaws fl) {
		
		try {
			this.listBody = new ArrayList<>();
			
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
		if(fl != null) {this.fl = fl;}
		for(SimulatorObserver o : this.listObserver) {
			o.onForceLawsChanged(fl.toString());
		}
	}

	public List<Body> getListBody() {
		return listBody;
	}

	public void setListBody(List<Body> listBody) {
		this.listBody = listBody;
	}
	
	//metodos

	public double getTimeReal() {
		return timeReal;
	}

	public void setTimeReal(double timeReal) {
		this.timeReal = timeReal;
		for(SimulatorObserver o : this.listObserver) {
			o.onDeltaTimeChanged(timeReal);
		}
	}

	public void advance() {
		for(Body o: listBody) {
			o.resetForce();
		}
		
		this.fl.apply(listBody);
		
		for(Body o: listBody) {
			o.move(this.timeReal);
		}
		
		timeActual = timeActual + timeReal;
		for(SimulatorObserver o : this.listObserver) {
			o.onAdvance(listBody, this.timeReal);
		}
		
	}
	
	public void addBody(Body b) {
		if(this.listBody.contains(b)==false) {
			this.listBody.add(b);
		}else {
			throw new IllegalArgumentException("body cant no be added");
		}
		for(SimulatorObserver o : this.listObserver) {
			o.onBodyAdded(listBody, b);
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
	public void reset() {
		this.listBody.clear();
		this.timeReal = 0;
		for(SimulatorObserver o : this.listObserver) {
			o.onReset(listBody, timeActual, timeReal, fl.toString());
		}
	}
	public void addObserver(SimulatorObserver o) {
		this.listObserver.add(o);
	}
	public String toString() {
		return getState().toString();
	}

}
