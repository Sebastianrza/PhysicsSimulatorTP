package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.PhysicsSimulator;

public class Controller {
	
	protected PhysicsSimulator ps;
	protected Factory<Body> fb;
	
	public Controller(PhysicsSimulator ps, Factory<Body> fb) {
		this.fb=fb;
		this.ps = ps;
	}
	
	//Getters and Setters
	public PhysicsSimulator getPs() {
		return ps;
	}

	public void setPs(PhysicsSimulator ps) {
		this.ps = ps;
	}

	public Factory<Body> getFb() {
		return fb;
	}

	public void setFb(Factory<Body> fb) {
		this.fb = fb;
	}

	public void loadBodies(InputStream in) {
		JSONObject lb = new JSONObject(new JSONTokener(in));
	}
	
	public void run(int n, OutputStream out, InputStream expOut, StateComparator cmp) {
		
	}
}
